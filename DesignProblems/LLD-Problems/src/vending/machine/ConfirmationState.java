package vending.machine;

import java.util.Map;
import java.util.Scanner;

public class ConfirmationState implements State{
    private Scanner scanner=new Scanner(System.in);
    private boolean success=true;
    private BillGenerator billGenerator;

    @Override
    public void onEntry(StateContext context) {
        System.out.println("Entered the confirmation state");
        this.billGenerator=new BasicBillGenerator();
    }

    @Override
    public void doWork(StateContext context) {
        System.out.println("Here are your selected products");
        VendingMachine v = context.vendingMachine;


        for(Map.Entry<Product, Integer> e:v.selectedProduct.getSelectedProduct().entrySet()){
            System.out.println(e.getKey().productBrand + " " + e.getKey().productType + "->" + e.getValue());
        }
        Double finalAmount=billGenerator.finalAmount(v.selectedProduct);
        System.out.println("The final bill amount is" + finalAmount);



        System.out.println("Press 1 to continue, Press 2 to edit");

        int selection=scanner.nextInt();

        while(selection!=1 && selection!=2){

            System.out.println("Invalid selection");
            selection=scanner.nextInt();
        }

        if(selection==2){
            success=false;
            return;
        }

        context.setFinalPrice(finalAmount);


    }

    @Override
    public void onExit(StateContext context) {
        System.out.println("Leaving the confirmation state");
    }

    @Override
    public void next(StateContext context) {
        if(success){
            context.setCurrentState(new PaymentState());
        }
        else
        {
            context.setCurrentState(new PaymentState());
        }
    }
}
