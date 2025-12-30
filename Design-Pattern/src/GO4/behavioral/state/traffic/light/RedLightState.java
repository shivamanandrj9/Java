package GO4.behavioral.state.traffic.light;

public class RedLightState implements TrafficLightState{
    @Override
    public void getCurrentState() {
        System.out.println("My current state is Red");
    }

    @Override
    public void onEntry() {
        System.out.println("Entering in Red state");
    }

    @Override
    public void doWork() throws InterruptedException {
        System.out.println("RED");
        Thread.sleep(2000);
    }

    @Override
    public void onExit() {
        System.out.println("Exiting the red state");
    }

    @Override
    public void next(TrafficLightContext context) {
        context.setCurrentState(new YellowLightState());
    }
}
