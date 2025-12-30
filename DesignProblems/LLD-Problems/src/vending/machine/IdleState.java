package vending.machine;

import java.util.Scanner;

public class IdleState implements State{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void onEntry(StateContext context) {
        System.out.println("Welcome to the vending kiosk");
    }

    @Override
    public void doWork(StateContext context) {
        System.out.println("Press 1 to start");
        int selection = scanner.nextInt();
        while(selection!=1){
            System.out.println("Invalid Selection");
        }
    }

    @Override
    public void onExit(StateContext context) {
        System.out.println("Leaving the idle state");
    }

    @Override
    public void next(StateContext context) {
        context.setCurrentState(new ProductSelectionState());
    }
}
