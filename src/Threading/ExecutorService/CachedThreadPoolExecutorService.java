package Threading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutorService {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        //Submitting the tasks
        for(int i=0;i<100;i++)
        {
            final Integer x=i;
            Runnable runnable = () -> System.out.println("Hi"+x+Thread.currentThread().getName());
            service.execute(runnable);
        }
    }
}
