package lru.cache.manager.impl;

import lru.entities.*;
import lru.exceptions.NoKeyInCache;
import lru.interfaces.CacheManager;

public class ThreadSafeCacheManager<K,V> implements CacheManager<K,V> {

    LRUCache<K,V> cache;

    public ThreadSafeCacheManager(int poolSize){
        this.cache=new LRUCache<>(poolSize);
    }

    @Override
    public synchronized void putCache(PutCacheRequest<K, V> req) {
        if(cache.getPos().containsKey(req.getKey())){
           Node<K,V> currNode=cache.getPos().get(req.getKey());
           Node<K,V> prevNode=currNode.getPrev();
           Node<K,V> nextNode=currNode.getNext();

           if(nextNode!=null){
               nextNode.setPrev(prevNode);
           }
           if(prevNode!=null){
               prevNode.setNext(nextNode);
           }

           if(cache.getHead()!=currNode){
               currNode.setPrev(null);
               currNode.setNext(cache.getHead());
               cache.setHead(currNode);
           }
           cache.getHead().setValue(req.getValue());
        }
        else
        {
            if(cache.isCacheFull()){
                Node<K,V> tailNode=cache.getTail();
                Node<K,V> prevNode=tailNode.getPrev();
                prevNode.setNext(null);
                cache.setTail(prevNode);
                cache.getPos().remove(tailNode.getKey());

                Node<K,V> newNode=new Node<>();
                newNode.setKey(req.getKey());
                newNode.setValue(req.getValue());

                newNode.setNext(cache.getHead());
                cache.setHead(newNode);
                cache.getPos().put(req.getKey(),newNode);

            }
            else
            {

                Node<K,V> newNode=new Node<>();
                newNode.setKey(req.getKey());
                newNode.setValue(req.getValue());

                newNode.setNext(cache.getHead());
                cache.setHead(newNode);
                cache.getPos().put(req.getKey(),newNode);
            }

        }
    }

    @Override
    public synchronized V getCache(GetCacheRequest<K> req) {
        if(cache.getPos().containsKey(req.getKey())){
            Node<K,V> currNode=cache.getPos().get(req.getKey());
            Node<K,V> prevNode=currNode.getPrev();
            Node<K,V> nextNode=currNode.getNext();

            if(nextNode!=null){
                nextNode.setPrev(prevNode);
            }
            if(prevNode!=null){
                prevNode.setNext(nextNode);
            }

            if(cache.getHead()!=currNode){
                currNode.setPrev(null);
                currNode.setNext(cache.getHead());
                cache.setHead(currNode);
            }
            return cache.getHead().getValue();

        }
        else
        {
           throw new NoKeyInCache("No key in the cache");
        }
    }
}
