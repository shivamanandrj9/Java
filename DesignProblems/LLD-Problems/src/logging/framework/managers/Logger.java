package logging.framework.managers;

import logging.framework.appenders.impl.ConsoleAppender;
import logging.framework.appenders.impl.FileAppender;
import logging.framework.entities.Log;
import logging.framework.enums.LogLevel;
import logging.framework.handlers.LogHandler;
import logging.framework.handlers.impl.ErrorHandler;
import logging.framework.handlers.impl.InfoHandler;

public class Logger {
    LogHandler head;

    public Logger(){
        ErrorHandler errorHandler=new ErrorHandler();
        InfoHandler infoHandler=new InfoHandler();

        ConsoleAppender consoleAppender=new ConsoleAppender();
        FileAppender fileAppender=new FileAppender();

        errorHandler.subscribe(fileAppender);
        errorHandler.subscribe(consoleAppender);

        infoHandler.subscribe(consoleAppender);

        this.head=errorHandler;
        errorHandler.setNext(infoHandler);
    }

    public void error(String message){
        Log log=new Log(System.currentTimeMillis(), message, LogLevel.ERROR);
        head.handle(log);
    }

    public void info(String message){
        Log log=new Log(System.currentTimeMillis(), message, LogLevel.INFO);
        head.handle(log);
    }
}
