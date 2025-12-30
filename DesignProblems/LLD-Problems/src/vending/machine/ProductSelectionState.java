package vending.machine;

import java.util.*;

public class ProductSelectionState implements State{

    private Scanner scanner= new Scanner(System.in);

    private boolean success = true;

    @Override
    public void onEntry(StateContext context) {
        System.out.println("Welcome to the product selection stage");
    }

    @Override
    public void doWork(StateContext context) {
        System.out.println("Here are the product which is available");
        System.out.println("Press 1 to continue, Press 2 to go back");

        int selection=scanner.nextInt();
        while(selection!=1 && selection!=2){
            System.out.println("Invalid selection");
            selection=scanner.nextInt();

        }
        if(selection==2){
            success=false;
            return;
        }

        VendingMachine v = context.vendingMachine;
        HashMap<Product, Integer> stock=v.stock;



        HashMap<Product, Integer> selected = new HashMap<>();



        for(Map.Entry<Product, Integer> e:stock.entrySet()){
            System.out.println("Press quantity" + " for "+e.getKey().productType + ", " + e.getKey().productBrand);
            System.out.println("Available quantity: "+ e.getValue());
            int qt=scanner.nextInt();
            selected.put(e.getKey(),qt);
        }
        ProductSelection productSelection = new ProductSelection(selected);
        context.vendingMachine.selectedProduct=productSelection;

        /*
        Add validation logic
         */
    }

    @Override
    public void onExit(StateContext context) {
        System.out.println("Leaving the product selection stage");
    }

    @Override
    public void next(StateContext context) {
        if(!success){
            context.setCurrentState(new IdleState());
        }
        else {
            context.setCurrentState(new ConfirmationState());
        }
    }
}
