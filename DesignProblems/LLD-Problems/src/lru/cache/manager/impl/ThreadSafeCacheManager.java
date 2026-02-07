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

            if(currNode==cache.getHead()){
                cache.getHead().setValue(req.getValue());
            }
            else if(currNode==cache.getTail()){
                prevNode.setNext(null);
                currNode.setPrev(null);
                cache.getHead().setPrev(currNode);
                currNode.setNext(cache.getHead());
                cache.setHead(currNode);
                cache.setTail(prevNode);
                cache.getHead().setValue(req.getValue());
            }
            else
            {
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                cache.getHead().setPrev(currNode);
                currNode.setNext(cache.getHead());
                cache.setHead(currNode);
                cache.getHead().setValue(req.getValue());
            }

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

                cache.getHead().setPrev(newNode);
                newNode.setNext(cache.getHead());
                cache.setHead(newNode);
                cache.getPos().put(req.getKey(),newNode);

            }
            else
            {

                Node<K,V> newNode=new Node<>();
                newNode.setKey(req.getKey());
                newNode.setValue(req.getValue());
                if(cache.getHead()==null){
                    cache.setHead(newNode);
                    cache.setTail(newNode);
                    cache.getPos().put(req.getKey(),newNode);
                    return;
                }
                newNode.setNext(cache.getHead());
                cache.getHead().setPrev(newNode);
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

            if(currNode==cache.getHead()){
                return cache.getHead().getValue();
            }
            else if(currNode==cache.getTail()){
                prevNode.setNext(null);
                currNode.setPrev(null);
                cache.getHead().setPrev(currNode);
                currNode.setNext(cache.getHead());
                return cache.getHead().getValue();
            }
            else
            {
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                cache.getHead().setPrev(currNode);
                currNode.setNext(cache.getHead());
                return cache.getHead().getValue();
            }

        }
        else
        {
           throw new NoKeyInCache("No key in the cache");
        }
    }
}
