package vending.machine;

import java.util.Map;
import java.util.Scanner;

public class VendingState implements State{

    private Boolean success=true;

    @Override
    public void onEntry(StateContext context) {
        System.out.println("Entered vending state");
    }

    @Override
    public void doWork(StateContext context) {
        System.out.println("Started vending");
        System.out.println("Updating the quantity in vending state");

        VendingMachine v=context.vendingMachine;
        for(Map.Entry<Product,Integer> e: v.selectedProduct.getSelectedProduct().entrySet()){
            v.stock.put(e.getKey(),v.stock.get(e.getKey())-e.getValue());

        }

    }

    @Override
    public void onExit(StateContext context) {
        System.out.println("Leaving the vending state");
    }

    @Override
    public void next(StateContext context) {
        if(success){
            context.setCurrentState(new IdleState());
        }
        else {
            context.setCurrentState(new RefundState());
        }
    }
}
