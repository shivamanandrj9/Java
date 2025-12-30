package vending.machine;

public class UPIPaymentProcessor implements PaymentProcessor{

    @Override
    public boolean pay(Double amount) {
        System.out.println("UPI Payment succesfful");
        return true;
    }
}
