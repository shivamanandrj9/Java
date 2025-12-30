package vending.machine;
//
//PaymentRegistry
//    - HashMap<PaymentType, PaymentProcessor> payment;
//    - void register(PaymentType t, PaymentProcessor p) {...}

import java.util.HashMap;

public class PaymentRegistry {

    HashMap<PaymentType, PaymentProcessor> payment=new HashMap<>();
    void register(PaymentType t, PaymentProcessor p){
        payment.put(t,p);
    }

    public PaymentRegistry(){
        payment.put(PaymentType.UPI, new UPIPaymentProcessor());
        payment.put(PaymentType.CASH, new CashPaymentProcessor());
    }

    public PaymentProcessor getPaymentProcessor(PaymentType t){
        /*
        Throw exception when the type is not there
         */
        return payment.get(t);
    }
}
