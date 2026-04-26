package logging.framework.appenders;

import logging.framework.entities.Log;
import logging.framework.interfaces.Observer;

public interface Appender extends Observer<Log> {
    void append(Log log);
}
