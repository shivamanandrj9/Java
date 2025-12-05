package Threading.Problems.produer.consumer;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;
    private Object lock;


    BlockingQueue(int cap){
        this.q=new ArrayDeque<>();
        this.capacity=cap;
        this.lock=new Object();
    }

    public boolean addElement(int value) throws InterruptedException {
        synchronized (lock){
            while(q.size()==capacity){
                System.out.println("Queue is full. Producer is waiting...");
                lock.wait();
            }
            q.add(value);
            System.out.println("Produced: " + value);
            lock.notifyAll(); //not just notify() because lets say the lock goes again to addElement then that lock gets wasted and whole operation is paused lifetime. and the same logic for "why we are using while and not the if".
            return true;
        }

    }

    public int removeElement() throws InterruptedException {
        synchronized (lock){
            while(q.isEmpty()){
                System.out.println("Queue is empty. Consumer is waiting...");
                lock.wait();
            }
            int ele = q.poll();
            System.out.println("Consumed: " + ele);
            lock.notifyAll();
            return ele;
        }
    }


}
