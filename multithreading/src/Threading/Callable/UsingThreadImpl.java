package Threading.Callable;

import java.util.concurrent.*;

public class UsingThreadImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //We first create an object of the callable class and put it inside the Future Task. Bullet ready
        Callable<Integer> callable = () -> {
            Thread.sleep(5000);
            return 101;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);


        Thread thread=new Thread(futureTask,"This");
        thread.start();

        //This is always blocking, regardless of daemon.
        System.out.println(futureTask.get());


        //If we want to block only when the callable is done with its task, then we can do
        if(futureTask.isDone())
        {
            System.out.println(futureTask.get());
        }
    }
}
