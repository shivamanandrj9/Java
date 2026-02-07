package lru.services;

import lru.cache.manager.impl.ThreadSafeCacheManager;
import lru.entities.GetCacheRequest;
import lru.entities.PutCacheRequest;
import lru.exceptions.NoKeyInCache;
import lru.interfaces.CacheManager;

public class CacheService {
    CacheManager<String,String> cacheManager;

    public CacheService(int poolSize){
        this.cacheManager=new ThreadSafeCacheManager<>(poolSize);
    }

    public void putCache(PutCacheRequest<String, String> req){
        cacheManager.putCache(req);
        System.out.printf(Thread.currentThread().getName()+": Successfully put cache with key: %s, value: %s%n",req.getKey(), req.getValue());
    }

    public String getCache(GetCacheRequest<String> req){
        try{
            String value=cacheManager.getCache(req);
            System.out.printf(Thread.currentThread().getName() + ": Successfully retrieved cache with key: %s, value: %s%n",req.getKey(),value );
            return value;
        } catch (NoKeyInCache e) {
            return "Invalid Cache Key Query";
        }
    }
}
