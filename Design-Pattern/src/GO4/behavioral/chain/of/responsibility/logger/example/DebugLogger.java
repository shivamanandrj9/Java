package GO4.behavioral.chain.of.responsibility.logger.example;

public class DebugLogger extends Logger {

    DebugLogger(int logLevel) {
        super(logLevel);
    }

    @Override
    public void printMessage(String message) {
        System.out.println("[DEBUG] : "+message);
    }


}
