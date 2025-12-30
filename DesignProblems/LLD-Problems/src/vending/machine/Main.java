package vending.machine;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Product p1=new Product(ProductType.SNACKS, ProductBrand.KURKURE,10d);
        Product p2=new Product(ProductType.SNACKS, ProductBrand.LAYS,15d);
        Product p3=new Product(ProductType.DRINKS, ProductBrand.REDBULL,100d);
        Product p4=new Product(ProductType.DRINKS, ProductBrand.COKE,25d);

        HashMap<Product,Integer> stock=new HashMap<>();
        stock.put(p1,4);
        stock.put(p2,3);
        stock.put(p3,6);
        stock.put(p4,1);

        StateContext stateContext = new StateContext(new VendingMachine(stock));



        while(true){
            stateContext.next();
        }
    }
}
