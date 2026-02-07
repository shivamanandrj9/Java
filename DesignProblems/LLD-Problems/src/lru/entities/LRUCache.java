package lru.entities;

import java.util.HashMap;

public class LRUCache<K,V> {

    int poolSize;
    Node<K,V> head;
    Node<K,V> tail;

    HashMap<K,Node<K,V>> pos;

    public LRUCache(int poolSize){
        this.poolSize=poolSize;
        this.head=null;
        this.tail=null;

        this.pos=new HashMap<>();
    }


    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public Node<K, V> getHead() {
        return head;
    }

    public void setHead(Node<K, V> head) {
        this.head = head;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public void setTail(Node<K, V> tail) {
        this.tail = tail;
    }

    public HashMap<K, Node<K, V>> getPos() {
        return this.pos;
    }

    public void setPos(HashMap<K, Node<K, V>> pos) {
        this.pos = pos;
    }

    public boolean isCacheFull(){
        if(poolSize==pos.size()){
            return true;
        }
        return false;
    }


}
