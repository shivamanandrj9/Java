package Threading.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    static int var = 0;

    static void increment(){
        var++;
    }

    static int getVar(){
        return var;
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
                increment();
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

/*
Here we will get some output less than 20000, because the operation is not atomic,
you should use AtomicInteger
 */
