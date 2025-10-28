package GO4.behavioral.chain.of.responsibility.logger.example;

public class InfoLogger extends Logger{
    InfoLogger(int logLevel) {
        super(logLevel);
    }

    @Override
    public void printMessage(String message) {
        System.out.println("[INFO] : "+message);
    }


}
