package Threading.LockingMechanism.ReentrantLockEx;

import java.util.concurrent.locks.*;

public class ProducerConsumerExample {

    private Lock lock = new ReentrantLock();
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();
    private final int MAX_CAPACITY = 5;
    private int currCap=0;

    public void produce() throws InterruptedException {
        lock.lock();
        try{
            while(currCap==MAX_CAPACITY){
                removed.await();
            }
            currCap++;
            added.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try{
            while(currCap==0){
                added.await();
            }
            currCap--;
            removed.signal();
        } finally {
            lock.unlock();
        }
    }
}
