package logging.framework.entities;

import logging.framework.enums.LogLevel;

public class Log {
    long dateTime;

    public String getMessage() {
        return message;
    }

    public long getDateTime() {
        return dateTime;
    }

    String message;

    public LogLevel getLogLevel() {
        return logLevel;
    }

    LogLevel logLevel;


    public Log(long dateTime, String message, LogLevel logLevel) {
        this.dateTime = dateTime;
        this.message = message;
        this.logLevel = logLevel;
    }
}
