package logging.framework.interfaces;

public interface Subject<T> {
    void notifyAll(T data);
    void subscribe(Observer<T> observer);
    void unsubscribe(Observer<T> observer);
}
