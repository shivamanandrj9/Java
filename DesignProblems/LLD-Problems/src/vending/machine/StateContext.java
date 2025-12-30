package vending.machine;

//15. StateContext
//    - State currentState;
//    - VendingMachine vendingMachine;
//    - public StateContext() {currentState = IdleState; currentState.onEntry(this); currentState.doWork(this)}
//    - public next(){ ... }

public class StateContext {

    State currentState;
    VendingMachine vendingMachine;

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    Double finalPrice;

    public StateContext(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
        currentState=new IdleState();
        currentState.onEntry(this);
        currentState.doWork(this);
    }

    public void setCurrentState(State state){
        this.currentState=state;
    }

    public void next(){
        currentState.onExit(this);
        currentState.next(this);

        currentState.onEntry(this);
        currentState.doWork(this);
    }


}
