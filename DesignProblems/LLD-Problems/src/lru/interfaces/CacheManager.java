package lru.interfaces;

import lru.entities.GetCacheRequest;
import lru.entities.PutCacheRequest;

public interface CacheManager<K,V> {
    void putCache(PutCacheRequest<K, V> req);
    V getCache(GetCacheRequest<K> req);
}
