package GO4.behavioral.strategy.example.robot;

public abstract class Robot {
    Talkable talkable;
    Flyable flyable;

    Robot(Talkable talkable, Flyable flyable){
        this.talkable=talkable;
        this.flyable=flyable;
    }

    abstract void projection();
}
