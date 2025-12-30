package vending.machine;

//7. <<interface>> BillGenerator
//   - Double finalAmount(ProductSelection selectedProduct)

public interface BillGenerator {

    Double finalAmount(ProductSelection selection);
}
