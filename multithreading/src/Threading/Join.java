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

        t1.join(5000); //this will put the current thread(here main) in the waiting state for 5 sec or until the target thread(here t1). Since it is not a virtual thread, if we not put this statement, main will continue its execution till last line and will wait for the runnable to finish its execution and then terminate. If we don't put any value inside the join, it will wait on this line until t1 is done with its execution.

        System.out.println("This waited for 5 sec then resumed");


//        Thread t2 = Thread.ofVirtual().unstarted(runnable);
//        t2.start();
//        t2.join();

    }
}
