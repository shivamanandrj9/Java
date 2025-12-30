Problem statement:

"Does this object behave differently depending on what state it is in?" If you have a variable named currentState and your methods are mostly switch(currentState), use the State Pattern.


We define

1. State interface

interface State {
void entry();   
void doWork();   
void exit();    

void next(Context context); //we do this if we have the fixed ordering of transitions
}


2. Context class, which have the reference to the state interface and depending on state it is currently in, this interface will have the concrete state class mapped to it.

class Context {
private State currentState;

    public Context(State startingState){
        currentState = startingState;
        currentState.entry();
        currentState.doWork();
    } //if we have fixed first state, we can directly plug it in without relying on user to provide the starting state;

    public void transitionTo(State newState) {
        currentState.onExit(); 

        currentState=newState;
        currentState.entry();
        currentState.doWork();
    }
    //similarly, agar hame pata hai fixed state transition to idhar parameter pass karne ki jarurate nahi. Us case me ye information ki next konsa state hai wo state me hi daal do. void next(Context context) ko implement karenge jisme context.currentState ko set kar denge.
    aur idhar wala method aisa dikhega
   
    public void nextState() {
        currentState.onExit(); 

        currentState.next(this);
        currentState.entry();
        currentState.doWork();
    }
}


