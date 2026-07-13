package Threading.ThreadSafeDataTypes.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    static AtomicInteger var = new AtomicInteger(0);

    static void increment(){
        var.incrementAndGet();
    }

    static void incrementByValue(Integer x){
        /*
        If you want to make some complex logic atomic
         */
        var.updateAndGet(current->{
            current+=x;
            if(current>100000){
                current=100000;
            }
            return current;
        });
    }

    static int getVar(){
        return var.get();
        /*
        We can't do this.something in a static method
         */
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for(int i=0;i<10000;i++){
                increment();
            }
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<10000;i++){
                incrementByValue(1);
            }
        });

        t1.start();
        t2.start();

        /*
        We need the join otherwise main will not wait, although t1 and t2 will continue running because they are not daemon thread.
         */
        t1.join();
        t2.join();

        System.out.println(getVar());
    }
}
