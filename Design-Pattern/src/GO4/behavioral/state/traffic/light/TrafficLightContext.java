package GO4.behavioral.state.traffic.light;


public class TrafficLightContext {
    TrafficLightState currentState;

    TrafficLightContext() throws InterruptedException {
        this.currentState=new RedLightState();

        currentState.onEntry();
        currentState.doWork();
    }

    void setCurrentState(TrafficLightState state){
        this.currentState=state;
    }

    void next() throws InterruptedException {
        currentState.onExit();

        currentState.next(this);
        currentState.onEntry();
        currentState.doWork();
    }

    //in case we dont' have the fixed ordering of the state, we can pass the next state here in the parameter and the next implementation iin the State classes will be removed.
}
