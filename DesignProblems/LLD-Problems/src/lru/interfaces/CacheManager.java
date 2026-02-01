Interface CacheManager<K,V>
{
    void putCache(PutCacheRequest<String, String> req);
    void getCache(GetCacheRequest<String> req);
}