package Threading.ExecutorService;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        Runnable runnable=() -> System.out.println("Hello"+Thread.currentThread().getName());

        //task to run after 10 seconds delay from now.
        executorService.schedule(runnable,10,TimeUnit.SECONDS);

        //task to run repeatedly after every 10 seconds after an initial delay of 15 sec.
        executorService.scheduleAtFixedRate(runnable,15,10,TimeUnit.SECONDS);

        //task will run repeatedly after 10 seconds of previous task completion.
        executorService.scheduleWithFixedDelay(runnable,15,10,TimeUnit.SECONDS);

    }
}
