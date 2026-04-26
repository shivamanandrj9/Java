package logging.framework.appenders.impl;

import logging.framework.appenders.Appender;
import logging.framework.entities.Log;

public class FileAppender implements Appender {

    @Override
    public synchronized void append(Log log) {
        System.out.println("Writing to File : "+log.getMessage());
    }

    @Override
    public void notify(Log data) {
        append(data);
    }

}
