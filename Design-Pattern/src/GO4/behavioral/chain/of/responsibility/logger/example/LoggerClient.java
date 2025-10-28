package GO4.behavioral.chain.of.responsibility.logger.example;

public class LoggerClient {

    public static void main(String[] args) {
        DebugLogger debugLogger=new DebugLogger(Logger.DEBUG);
        ErrorLogger errorLogger=new ErrorLogger(Logger.ERROR);
        InfoLogger infoLogger=new InfoLogger(Logger.INFO);

        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        infoLogger.logMessage(Logger.INFO, "This is info level log");
        infoLogger.logMessage(Logger.DEBUG, "This is debug level log");
        infoLogger.logMessage(Logger.ERROR, "This is error level log");
    }
}
