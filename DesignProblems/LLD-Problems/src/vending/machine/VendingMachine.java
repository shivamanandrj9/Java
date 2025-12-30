package vending.machine;

//5. VendingMachine
//    - HashMap<Product, Integer> stock;
//    - ProductSelection selectedProduct;
//    - void makePayment(Double amount) {...}
//    - void updateInventory() {...}
//    - Bill generateBill() {...}

import java.util.HashMap;

public class VendingMachine {
    HashMap<Product,Integer> stock;
    ProductSelection selectedProduct;

    public VendingMachine(HashMap<Product,Integer> stock){
        this.stock=stock;
    }
}
