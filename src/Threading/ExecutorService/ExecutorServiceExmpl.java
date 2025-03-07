package Threading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExmpl {

    public static void main(String[] args) {

        //FYI
        int coreCount=Runtime.getRuntime().availableProcessors();

        int numberOfThread=2;

        //Initialized the executor service
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThread);

        //Submitting the tasks
        for(int i=0;i<10;i++)
        {
            final Integer x=i;
            Runnable runnable = () -> System.out.println("Hi"+x);
            executorService.execute(runnable);
        }
    }
}
