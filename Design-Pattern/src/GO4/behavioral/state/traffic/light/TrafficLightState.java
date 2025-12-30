package GO4.behavioral.state.traffic.light;

public interface TrafficLightState {
    //here we have fixed state transition to ye info idhar hi daal do.

    void getCurrentState();

    void onEntry();
    void doWork() throws InterruptedException;
    void onExit();

    void next(TrafficLightContext context);
}
