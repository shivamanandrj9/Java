package lru;

import lru.entities.GetCacheRequest;
import lru.entities.PutCacheRequest;
import lru.services.CacheService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CacheService cacheService=new CacheService(2);
        /*
        For the testing purpose, we will spin up 2 threads and add operations in them.
         */


//
//        cacheService.putCache(new PutCacheRequest<>("abc","cde"));
//        cacheService.putCache(new PutCacheRequest<>("abc","efg"));
//        cacheService.getCache(new GetCacheRequest<String>("abc"));
//
//        cacheService.putCache(new PutCacheRequest<>("cde","ghi"));
//        cacheService.getCache(new GetCacheRequest<String>( "abc"));
//        cacheService.putCache(new PutCacheRequest<>("jkl","mno"));
//        System.out.println(cacheService.getCache(new GetCacheRequest<String>("abc")));


        Thread thread1=new Thread(()->{
            cacheService.putCache(new PutCacheRequest<>("abc","cde"));
            cacheService.putCache(new PutCacheRequest<>("abc","efg"));
            cacheService.putCache(new PutCacheRequest<>("abc","cde"));
            cacheService.putCache(new PutCacheRequest<>("abc","efg"));
        });

        Thread thread2=new Thread(()->{

                cacheService.putCache(new PutCacheRequest<>("cde","pqr"));
                cacheService.putCache(new PutCacheRequest<>("mno","ttl"));
                cacheService.putCache(new PutCacheRequest<>("dhd","xyz"));
                cacheService.putCache(new PutCacheRequest<>("you","not"));


        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
