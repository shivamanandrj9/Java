package Threading.ThreadSafeDataTypes.queueInterface.blockingQueueInterface;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<String> bq=new ArrayBlockingQueue<>(10);

        Thread t1=new Thread(new Producer(bq));
        Thread t2=new Thread(new Consumer(bq));

        t1.start();
        t2.start();

    }

    public static class Producer implements Runnable{

        BlockingQueue<String> bq;

        public Producer(BlockingQueue<String> bq){
            this.bq=bq;
        }

        @Override
        public void run() {
            while(true){
                try {
                    String val="" + System.currentTimeMillis();
                    /*
                    If the bq is full. This thread will sleep and will wait for it to be notified by the when there is something taken out of the queue.
                     */
                    bq.put(val);
                    System.out.println("Produced -> " + val);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static class Consumer implements Runnable{

        BlockingQueue<String> bq;

        public Consumer(BlockingQueue<String> bq){
            this.bq=bq;
        }

        @Override
        public void run() {
            while(true){
                try {
                    /*
                    If the bq empty. This thread will sleep and will wait for it to be notified by the when there is something taken out of the queue.
                     */
                    String val=bq.take();
                    System.out.println("Consumed -> " + val);;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
