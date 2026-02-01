# Problem Statement

Design LRU Cache (Least Recently Used). LRU Cache is a type of chache replacement policy that evicts the least recentry accessed item when the cache reaches its capacity. 

Example:

put(1, A)     // cache: {1:A}
put(2, B)     // cache: {1:A, 2:B}
put(3, C)     // cache: {1:A, 2:B, 3:C}
get(1)        // access key 1 → makes it most recently used
put(4, D)     // key 2 is least recently used → evict it


# Requirements

1. To this service, request can come like get(key) or put(key, value). these operation will also update the recency.
2. In case the key is not present we will return -1
3. There will be an algorithm working in order to manage the cache. We will be using doubly Linked List + Map
4. Keep the Key, Value as generics.
5. We will have this thread safe, multiple request can access this and should not corrupt.

# Entities

GetCacheRequest<K>
{
    K key;
}

PutCacheRequest<K,V>
{
    K key;
    V value;
}

Node<K,V>
{
    K key;
    V value;
    Node<K,V> prev;
    Node<K,V> next;
}

LRUCache<K,V>
{
    Node<K,V> head;
    Node<K,V> tail;
    HashMap<K, Node<K,V>> pos;
}



# Controllers



# Services

class CacheService<String, String>
{   
    ThreadSafeCacheManager<String, String> cacheManager;

    void putCache(PutCacheRequest<String, String> req){...};
    void getCache(GetCacheRequest<String> req){...};
}

# Interface

<<interface>> CacheManager<K,V> 

# CacheManagerImpl

class ThreadSafeCacheManager<K,V> implements CacheManager<K,V>
{

    int poolSize;

    void putCache(PutCacheRequest<String, String> req){...};
    void getCache(GetCacheRequest<String> req){...};
}








