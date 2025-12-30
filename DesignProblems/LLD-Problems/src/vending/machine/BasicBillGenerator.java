package vending.machine;
//
//BasicBillGenerator implements BillGenerator
//   - Double finalAmount(ProductSelection selectedProduct) {...}

import java.util.HashMap;
import java.util.Map;

public class BasicBillGenerator implements BillGenerator {
    public Double finalAmount(ProductSelection selection){

        HashMap<Product, Integer> selectedProduct = selection.getSelectedProduct();

        Double finalPrice=0d;
        for(Map.Entry<Product,Integer> e:selectedProduct.entrySet()){
            finalPrice+=(e.getKey().price*e.getValue());
        }
        return finalPrice;
    }

}
