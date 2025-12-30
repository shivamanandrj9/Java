package vending.machine;

public class CashPaymentProcessor implements PaymentProcessor{

    @Override
    public boolean pay(Double amount) {
        /*
        Implemenation for the bill payment
         */
        System.out.println("Cash payment success");
        return true;
    }
}
