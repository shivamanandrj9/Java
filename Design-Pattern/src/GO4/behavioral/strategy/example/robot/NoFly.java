package GO4.behavioral.strategy.example.robot;

public class NoFly extends Flyable{
    @Override
    void fly() {
        System.out.println("This robot cannot fly");
    }
}
