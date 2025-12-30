package GO4.behavioral.state.traffic.light;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TrafficLightContext context=new TrafficLightContext();

        context.next();
        context.next();
        context.next();
        context.next();
    }
}
