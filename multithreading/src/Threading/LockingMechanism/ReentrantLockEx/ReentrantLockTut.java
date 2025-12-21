package Threading.LockingMechanism.ReentrantLockEx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTut {


    private static final ReentrantLock lock = new ReentrantLock();
    /*
    If we pass new ReentrantLock(true) -> This will make it a fair lock where a queue will be used for all the waiting threads.

    A non fair lock has more throughput because it does not overhead of queuing etc, also let's say T1 and T2 were running on two different cores. T1 had the lock, T2 does not require lock for now but will require it in the future and T3 need it immediately but it was put to blocked(parked).

     Now T1 released the lock and as soon as it released T2 grabbed it. Now the cpu had already loaded some data and might be using cache so T2 will run faster and will require less context switches as well.
    */

    private static int sharedCounter=0;

    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        basicLockUnlock();
        reentrantExample();
        tryLockExample();
        tryLockWithTimeoutExample();
        interruptibleLockExample();
        conditionExample();
    }

    static void basicLockUnlock(){

        lock.lock(); //We acquired the lock.

        try {
            sharedCounter++;
            System.out.println("Counter = " + sharedCounter);
        } finally{
            lock.unlock(); //Mandatory
        }
        //Always use finally because there might be case when an exception could be there and you end up not releasing the lock
    }

    static void reentrantExample(){
        lock.lock();
        try{
            System.out.println("Hold count after first lock: " + lock.getHoldCount());
            reentrantExample();
            //So the same thread can hold this lock multiple times. If this feature was not there then any recursive call will lead to the deadlock.
        } finally {
            lock.unlock();
        }
    }

    static void tryLockExample(){
        if(lock.tryLock()){
            //so it will try to acquire the lock if acquired then return true else you can continue with the rest of the code flow. This will avoid causing any deadlock.
            //One weird thing is that even if the fairness is set to true. The trylock will jump in and get the lock. To fix this use lock.tryLock(0, TimeUnits.SECONDS);
            try{
                System.out.println("Lock acquired using tryLock()");
            } finally{
                lock.unlock();
            }
        }
        else{
            System.out.println("Could not acquire the lock. Doing some other stuff.");
        }
    }

    static void tryLockWithTimeoutExample() throws InterruptedException {
        if(lock.tryLock(5, TimeUnit.SECONDS)){
            //so it will wait for 5 sec to acquire the loc
            try{
                System.out.println("Lock acquired using tryLock()");
            } finally{
                lock.unlock();
            }
        }
        else{
            System.out.println("Could not acquire the lock. Doing some other stuff.");
        }
    }

    static void interruptibleLockExample(){
        Thread t = new Thread(() -> {
            try{
                lock.lockInterruptibly();
                //So this lock which is held by this thread is interruptible meaning, that if we call t.interrupt() anywhere. this thread will no longer wait for the lock and jump to the catch block. This interruptibility also works with the tryLock with timeout.
                try{
                    System.out.println("Interruptible lock acquired");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t.start();
        t.interrupt(); //interrupt while waiting
    }

    static void conditionExample() throws InterruptedException {
        Thread waitingThread = new Thread(() -> {
            lock.lock();
            try{
                System.out.println("Waiting thread waiting");
                condition.await();
                //this released the lock and awaits
                //Similar to lock.wait();
                System.out.println("Waiting thread resumed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread signallingThread = new Thread(() -> {
            lock.lock();

            try {
                System.out.println("Signalling thread signalling");
                condition.signal();
                //similar to notify() there is also signalAll() ~ notifyAll();
            } finally {
                lock.unlock();
            }
        });

        waitingThread.start();
        Thread.sleep(1000);
        signallingThread.start();
    }

}
