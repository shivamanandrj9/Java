package lru.exceptions;

public class NoKeyInCache extends RuntimeException {
    public NoKeyInCache(String message) {
        super(message);
    }
}
