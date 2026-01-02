package Threading.LockingMechanism.ReadWriteLockEx;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTut {

    //static because main se call kar rahe and we can only access static from the static
    private static ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    //We mandatorily need this
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();//only write lock allows the condition statement

    private static int count=0;

    private static int readResource() throws InterruptedException {
        readLock.lock();
        try{
            System.out.println("Read the value as : " + count);
            return count;
        } finally {
            readLock.unlock();
        }

    }

    private static void writeResource(){
        writeLock.lock();
        try{
            Thread.sleep(3000);
            System.out.println("Incrementing the value");
            count++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
           writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        List<Thread> readerThread = new ArrayList<>();
        List<Thread> writeThread=new ArrayList<>();
        for(int i=0;i<10;i++){
            readerThread.add(new Thread(() -> {
                try {
                   readResource();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));

            writeThread.add(new Thread(() -> {
                writeResource();
            }));

        }

        for(int i=0;i<10;i++){
            writeThread.get(i).start();
            readerThread.get(i).start();
        }

    }

}
