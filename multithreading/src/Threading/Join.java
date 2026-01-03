package Threading;

import static java.lang.Thread.sleep;

public class Join {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for(int i=0;i<5;i++){
                System.out.println("Running");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1=new Thread(runnable);
        t1.start();

        t1.join(5000);

        /*
        1. Main thread will wait here (WAITING STATE). If t1 finishes before 5 sec, the main will continue to next line (WAITING -> RUNNABLE).
        2. However if t1 does not finishes before 5 sec, the main will continue executing next lines, the main thread will die.
        3. JVM will keep running t1 as it is not a daemon thread.
        4. If you don't put any time, the main will be in WAITING state until t1 terminates.


         */

        System.out.println("This waited for 5 sec then resumed");


//        Thread t2 = Thread.ofVirtual().unstarted(runnable);
//        t2.start();
//        t2.join();

    }
}
