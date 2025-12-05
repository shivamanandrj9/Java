package single.responsibility;

import java.sql.*;
import java.util.Map;

public class Solution1 {
    //below is the solution

}

// Order.java
// Same package so think that Order is there

//First method
interface Validator<T>{
    public void validate(T entity);
}

class OrderValidator implements Validator<Order>{
    @Override
    public void validate(Order order){
        if (order.items == null || order.items.isEmpty()) throw new IllegalArgumentException("No items");
        if (order.customerEmail == null || !order.customerEmail.contains("@")) throw new IllegalArgumentException("Invalid email");
    }
}

interface PricingService{
    public void calculateTotal(Order order) throws SQLException;
}

class JDBCPricingService implements PricingService{

    private Connection conn;

    public JDBCPricingService(String jdbcUrl) throws SQLException {
        conn = DriverManager.getConnection(jdbcUrl);
    }

    @Override
    public void calculateTotal(Order order) throws SQLException {
        // 2. compute total by reading prices from DB (prices table item_id, price)
        double total = 0;
        PreparedStatement p = conn.prepareStatement("SELECT price FROM prices WHERE item_id = ?");
        for (Map.Entry<String,Integer> e : order.items.entrySet()) {
            p.setString(1, e.getKey());
            ResultSet rs = p.executeQuery();
            if (!rs.next()) throw new IllegalArgumentException("Unknown item " + e.getKey());
            double price = rs.getDouble(1);
            total += price * e.getValue();
            rs.close();
        }
        order.total = total;
    }
}

interface DiscountService{
    public void calculateDiscount(Order order);
}

class SimpleDiscountService implements DiscountService{

    @Override
    public void calculateDiscount(Order order) {
        if (order.total > 1000) {
            order.total = order.total * 0.9; // 10% off
        } else if (order.items.values().stream().mapToInt(Integer::intValue).sum() > 10) {
            order.total = order.total - 50;
        }
    }
}






