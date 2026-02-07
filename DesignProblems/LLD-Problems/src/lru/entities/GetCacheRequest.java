package lru.entities;

public class GetCacheRequest<K> {
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    K key;

    public GetCacheRequest(K key){
        this.key=key;
    }

}
