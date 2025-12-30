package vending.machine;

//<<interface>> State
//    - void onEntry(StateContext context);
//    - void doWork(StateContext context);
//    - void onExit(StateContext context);
//    - void next(StateContext context);

public interface State {
    void onEntry(StateContext context);
    void doWork(StateContext context);
    void onExit(StateContext context);

    void next(StateContext context);
}
