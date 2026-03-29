package task.management.system.interfaces;


public interface Observer<T>{
    void update(T event);
}