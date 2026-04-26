package logging.framework.handlers.impl;

import logging.framework.entities.Log;
import logging.framework.enums.LogLevel;
import logging.framework.handlers.LogHandler;
import logging.framework.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler extends LogHandler {

    List<Observer<Log>> listeners;
    final LogLevel level=LogLevel.ERROR;

    LogHandler next;

    public ErrorHandler(){
        this.listeners=new ArrayList<>();
    }

    @Override
    public void handle(Log log) {
        if(log.getLogLevel()==this.level) {
            System.out.println("["+log.getDateTime()+"] ,"+ "[ " + log.getLogLevel() + "] :" + log.getMessage() );
            notifyAll(log);
        } else {
            if(next!=null){
                next.handle(log);
            }
        }
    }

    @Override
    public void notifyAll(Log data) {
        for(Observer<Log> observer: listeners){
            observer.notify(data);
        }
    }

    @Override
    public void subscribe(Observer<Log> observer) {
        listeners.add(observer);
    }

    @Override
    public void unsubscribe(Observer<Log> observer) {
        listeners.remove(observer);
    }

    public void setNext(LogHandler next) {
        this.next = next;
    }
}
