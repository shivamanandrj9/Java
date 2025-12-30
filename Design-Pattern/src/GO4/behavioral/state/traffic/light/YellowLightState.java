package GO4.behavioral.state.traffic.light;

public class YellowLightState implements TrafficLightState{

    @Override
    public void getCurrentState() {
        System.out.println("My current state is Yellow");
    }

    @Override
    public void onEntry() {
        System.out.println("Entering in Yellow state");
    }

    @Override
    public void doWork() throws InterruptedException {
        System.out.println("YELLOW");
        Thread.sleep(2000);
    }

    @Override
    public void onExit() {
        System.out.println("Exiting the yellow state");
    }

    @Override
    public void next(TrafficLightContext context) {
        context.setCurrentState(new RedLightState());
    }
}
