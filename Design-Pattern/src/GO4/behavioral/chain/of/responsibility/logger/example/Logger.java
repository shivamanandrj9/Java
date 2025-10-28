package GO4.behavioral.chain.of.responsibility.logger.example;

public abstract class Logger {
    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;

    protected Logger next;
    private int logLevel;

    Logger(int logLevel){
        this.logLevel=logLevel;
    }

    public void setNext(Logger next){
        this.next=next;
    }

    public void logMessage(int level, String message){
        if(this.logLevel>=level){
            printMessage(message);
        }
        else if(this.next!=null)
        {
            this.next.logMessage(level,message);
        }
    }

    public abstract void printMessage(String message);

}
