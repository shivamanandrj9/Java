package logging.framework.appenders.impl;

import logging.framework.appenders.Appender;
import logging.framework.entities.Log;

public class ConsoleAppender implements Appender {
    @Override
    public synchronized void append(Log log) {
        System.out.println("Appending to console : "+log.getMessage());
    }

    @Override
    public void notify(Log data) {
        append(data);
    }
}
