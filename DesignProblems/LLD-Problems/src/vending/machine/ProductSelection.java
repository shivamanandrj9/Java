package vending.machine;

//6. ProductSelection
//    - HashMap<Product, Integer> selectedProduct;

import java.util.HashMap;

public class ProductSelection {
    HashMap<Product, Integer> selectedProduct;

    public ProductSelection(HashMap<Product, Integer> selectedProduct){
        this.selectedProduct=selectedProduct;
    }

    HashMap<Product, Integer> getSelectedProduct(){
        return this.selectedProduct;
    }
}
