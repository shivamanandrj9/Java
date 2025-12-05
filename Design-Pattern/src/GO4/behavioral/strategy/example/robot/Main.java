package GO4.behavioral.strategy.example.robot;

public class Main {
    public static void main(String[] args) {
        Robot r=new CompanionRobot();
        r.flyable.fly();
        r.talkable.talk();
    }
}
