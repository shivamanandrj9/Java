package GO4.behavioral.chain.of.responsibility.logger.example;

public class ErrorLogger extends Logger{
    ErrorLogger(int logLevel) {
        super(logLevel);
    }

    @Override
    public void printMessage(String message) {
        System.out.println("[ERROR] : "+message);
    }


}
