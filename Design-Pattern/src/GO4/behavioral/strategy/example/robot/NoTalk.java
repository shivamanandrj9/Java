package GO4.behavioral.strategy.example.robot;

public class NoTalk extends Talkable{

    @Override
    void talk() {
        System.out.println("This robot won't talk");
    }
}
