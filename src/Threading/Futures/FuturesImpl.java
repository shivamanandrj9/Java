package Threading.Futures;

import java.util.concurrent.*;

public class FuturesImpl {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Callable<String> callable = () -> {
            return Thread.currentThread().getName();
        };


        //Now when we want to submit it to executor service. We will get a placeholder of Future type in return as a placeholder.

        Future<String> placeholder = service.submit(callable);

        //Now there are multiple methods that come along with the placeholder

        if (placeholder.isDone()) {
            System.out.println("It is done now");
        }

        try {
            System.out.println(placeholder.get());
        } catch (InterruptedException e) {
            /* InterruptedException: This exception is thrown if the current thread was interrupted while waiting for the result of the Future.get() method. This can happen if another thread interrupts the current thread while it is blocked waiting for the result. */
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            /* ExecutionException: This exception is thrown if the computation of the task represented by the Future threw an exception. The ExecutionException wraps the actual exception thrown by the task, which can be retrieved using the getCause() method. */
            throw new RuntimeException(e);
        }

        try {
            //We want that it should that we will be waiting for a maximum of 1 sec after that just throw the Timeout Exception and terminate that task.
            String result = placeholder.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //This will cancel the excution of this task if it has not been started yet but if it has started we can set whether we want to interrupt it or not.
        placeholder.cancel(true);

        //This checks if the task was cancelled before running
        System.out.println(placeholder.isCancelled());

        // Will return true if the task has been successfull or threw any exception.
        System.out.println(placeholder.isDone());
    }
}
