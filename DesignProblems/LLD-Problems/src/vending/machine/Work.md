Requirements:

1. User can select the product type
2. 1 product type can have multiple brands offering the same product.
3. User can select the exact product with the brand.
4. User can select the quantity.
5. Based on the quantity and the price, final price will be generated.
6. User will be asked to pay via different payment methods.
7. On successful payment the product will be dispensed.
8. Machine will keep track of available products counts and their prices etc.
9. Machine will be verifying the payment and after successful payment only the product will be dispensed.
10. Multiple product selection? -> yes
11. Failure handling? -> In case of failed payment, will the user have to restart again, surely no as it will be a bad user experience.
12. There should be an audit trail of the products.


Entities


1. User 
    - String userId

2. Product
    - ProductType type;
    - ProductBrand brand;
    - Double price;

3. <<Enum>> ProductType
4. <<Enum>> ProductBrand

5. VendingMachine
    - HashMap<Product, Integer> stock;
    - ProductSelection selectedProduct;

6. ProductSelection
    - HashMap<Product, Integer> selectedProduct;

7. <<interface>> BillGenerator
   - Double finalAmount(ProductSelection selectedProduct)

8. BasicBillGenerator implements BillGenerator
   - Double finalAmount(ProductSelection selectedProduct) {...}

9. <<interface>> PaymentProcessor
    - boolean pay(Double amount)



10. CashPaymentProcessor implements PaymentProcessor
    - boolean pay(Double amount) {...}
11. <<enum>> PaymentType
    - CASH, UPI

12. UPIPaymentProcessor implements PaymentProcessor
    - boolean pay(Double amount) {...}

13. PaymentRegistry
    - HashMap<PaymentType, PaymentProcessor> payment;
    - void register(PaymentType t, PaymentProcessor p) {...}

14. <<interface>> State
    - void onEntry(StateContext context);
    - void doWork(StateContext context);
    - void onExit(StateContext context);
    - void next(StateContext context);

15.States 
    - IdleState
    - ProductSelectionState
    - ConfirmationState
    - PaymentState
    - RefundState
    - VendingState

17. IdleState -> ProductSelectionState -> ConfirmationState -> PaymentState --(if success)-->  VendingState -> IdleState

PaymentState ---(if failed)--> ConfirmationState

15. StateContext
    - State currentState;
    - VendingMachine vendingMachine;
    - public StateContext() {currentState = IdleState; currentState.onEntry(this); currentState.doWork(this)}
    - public next(){ ... }






