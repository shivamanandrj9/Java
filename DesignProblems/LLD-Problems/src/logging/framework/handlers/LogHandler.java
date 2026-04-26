package logging.framework.handlers;

import logging.framework.entities.Log;
import logging.framework.interfaces.Subject;

public abstract class LogHandler implements Subject<Log> {
    public abstract void handle(Log log);
}
