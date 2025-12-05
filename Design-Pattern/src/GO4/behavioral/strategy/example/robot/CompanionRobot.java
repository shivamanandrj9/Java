package GO4.behavioral.strategy.example.robot;

public class CompanionRobot extends Robot{
    CompanionRobot(){
        super(new NormalTalk(),new NoFly());
    }

    @Override
    void projection() {
        System.out.println("This has companion projection");
    }
}
