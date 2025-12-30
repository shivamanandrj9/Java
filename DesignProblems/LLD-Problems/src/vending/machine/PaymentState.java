package vending.machine;

import java.util.Scanner;

public class PaymentState implements State{

    private Scanner scanner=new Scanner(System.in);
    private PaymentRegistry paymentRegistry = new PaymentRegistry();
    private Boolean success=true;

    @Override
    public void onEntry(StateContext context) {
        System.out.println("Entered the payment state");
    }

    @Override
    public void doWork(StateContext context) {

        System.out.println("To make payment press 1, to go back press 2");
        int selection= scanner.nextInt();
        if(selection==2){
            success=null;
            return;
        }


        System.out.println("Select the payment method");
        selection= scanner.nextInt();
        System.out.println("Press 1 for "+ PaymentType.UPI);
        System.out.println("Press 2 for "+ PaymentType.CASH);



        PaymentProcessor processor;

        if(selection==1){
            processor = paymentRegistry.getPaymentProcessor(PaymentType.UPI);
        }
        else
        {
            processor=paymentRegistry.getPaymentProcessor(PaymentType.CASH);
        }

        processor.pay(context.getFinalPrice());

    }

    @Override
    public void onExit(StateContext context) {
        System.out.println("Leaving the payment state");
    }

    @Override
    public void next(StateContext context) {
        if(success==null){
            context.setCurrentState(new ConfirmationState());
        }
        else if(success){
            context.setCurrentState(new VendingState());
        }
        else {
            context.setCurrentState(new RefundState());
        }

    }
}
