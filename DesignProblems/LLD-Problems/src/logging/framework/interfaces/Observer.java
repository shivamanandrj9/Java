package logging.framework.interfaces;

public interface Observer<T> {
    void notify(T data);
}
