package Threading;

import static java.lang.Thread.sleep;

public class Join {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for(int i=0;i<10;i++){
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

        t1.join(5000); //this will put the current thread(here main) in the waiting state until the target thread(here t1) completes, or 5 s passes(whichever earlier). After this t1 keeps on running but the main also continues its execution.

        System.out.println("This waited for 5 sec then resumed");

    }
}
