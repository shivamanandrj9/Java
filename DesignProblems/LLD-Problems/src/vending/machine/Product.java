package vending.machine;

//2. Product
//    - ProductType type;
//    - ProductBrand brand;
//    - Double price;

public class Product {
    ProductType productType;
    ProductBrand productBrand;
    Double price;

    public Product(ProductType productType, ProductBrand productBrand, Double price){
        this.productType=productType;
        this.productBrand=productBrand;
        this.price=price;
    }
}
