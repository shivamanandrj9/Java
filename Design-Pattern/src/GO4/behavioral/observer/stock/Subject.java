package GO4.behavioral.observer.stock;

public interface Subject<T> {
    void register(Observer<T> o);
    void unregister(Observer<T> o);
    void notifyObservers();
}
