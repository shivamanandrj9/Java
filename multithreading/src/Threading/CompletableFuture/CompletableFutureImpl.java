package Threading.CompletableFuture;

/*
It is used for performing asynchronous non-blocking computations and trigger dependent computations which can also be asynchronous.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureImpl {
    public static void main(String[] args) {

        //This will run the runnable
        CompletableFuture<Void> f2= CompletableFuture.runAsync(() -> System.out.println("Hello world"));

        //This will run the supplier method(the method that returns something but does not take input).
       CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
           return "Hello";
       });

       //to pass a parameter, but don't change it in multiple futures as it will start a race condition.
        String myName="Shivam";
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            return "Hello"+myName;
        });


        //.get() is a blocking call
        try {
            String valOff1=f1.get();
            System.out.println(valOff1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //If that thread is not complete yet or has failed due to some exception, it will return the default value
        String valOff1 = f1.getNow("Default value");


        //Here we are collectively monitoring each of the thread that are executing above independently.
        CompletableFuture<Void> f = CompletableFuture.allOf(f1,f2,f3);

        /*
        1) .get() is a blocking operation and will wait even if one of the thread is yet to be executed.
        2) If any of the f1, f2 or f3 fail, this f.get() will throw execution exception.
         */
        try {
            f.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        /*
        CompletableFuture (e.g., the one returned by allOf) to complete exceptionally. When you call f.join(), it will throw a CompletionException that wraps the original checked exceptions like NullPointerException. Since join() throws unchecked exceptions, the compiler doesn't force you to catch it, but if it occurs and isn't handled elsewhere, your program will indeed terminate with that exception.
         */
        f.join();




    }
}
