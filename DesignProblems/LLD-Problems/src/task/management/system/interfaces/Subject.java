package task.management.system.interfaces;

public interface Subject<T> {
    void register(Observer<T> o);
    void deRegister(Observer<T> o);
    void notifyAll(T event);
}