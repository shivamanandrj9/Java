package single.responsibility;

import java.io.FileWriter;
import java.sql.*;
import java.util.Map;

public class Ex1 {
    //below is the example
}

// Order.java
class Order {
    public String id;
    public String customerEmail;
    public Map<String, Integer> items; // itemId -> qty
    public double total;
    public String notes;
    public Order(String id, String email, Map<String,Integer> items) {
        this.id = id; this.customerEmail = email; this.items = items;
    }
}


// OrderProcessor.java (monolith)
class OrderProcessor {
    private Connection conn;

    public OrderProcessor(String jdbcUrl) throws SQLException {
        conn = DriverManager.getConnection(jdbcUrl);
    }

    // Single method that does everything
    public void processOrder(Order order) throws Exception {
        // 1. validate
        if (order.items == null || order.items.isEmpty()) throw new IllegalArgumentException("No items");
        if (order.customerEmail == null || !order.customerEmail.contains("@")) throw new IllegalArgumentException("Invalid email");

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

        // 3. apply discount rules (complex)
        if (total > 1000) {
            order.total = total * 0.9; // 10% off
        } else if (order.items.values().stream().mapToInt(Integer::intValue).sum() > 10) {
            order.total = total - 50;
        }

        // 4. persist order to orders table
        PreparedStatement ins = conn.prepareStatement("INSERT INTO orders (id, email, total, notes) VALUES (?,?,?,?)");
        ins.setString(1, order.id);
        ins.setString(2, order.customerEmail);
        ins.setDouble(3, order.total);
        ins.setString(4, order.notes);
        ins.executeUpdate();

        // 5. export to CSV (append)
        try (FileWriter fw = new FileWriter("export.csv", true)) {
            fw.append(order.id).append(",")
                    .append(order.customerEmail).append(",")
                    .append(String.valueOf(order.total)).append("\n");
        }

        // 6. send email notification (simple SMTP simulation)
        sendEmail(order.customerEmail, "Order Received", "Your order " + order.id + " total: " + order.total);

        // 7. log
        try (FileWriter log = new FileWriter("processor.log", true)) {
            log.append("Processed order ").append(order.id).append(" total=").append(String.valueOf(order.total)).append("\n");
        }
    }

    private void sendEmail(String to, String subject, String body) {
        // pretend SMTP client here
        System.out.println("EMAIL to=" + to + " subj=" + subject + " body=" + body);
    }

    public void close() throws SQLException {
        conn.close();
    }
}
