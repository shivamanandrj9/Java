package Threading.CompletableFuture;

import java.util.concurrent.*;

public class PowerOfCompeletableFutures {
    public static void main(String[] args) {


        /*
        supplyAsync() returns a CompletableFuture<?> with the return type that we return inside the supplier method.
        thenApply - this uses the CompletableFuture<?> object and we can transform it to some other type of CompletableFuture<Type2> after doing some operation on it.
        thenApplyAsync - this will do that other part in another thread.

        The thenApply method by default uses the same thread that completed the previous stage if it's available. If the previous stage completed synchronously (in the calling thread), then thenApply will execute in the calling thread as well. If the previous stage completed asynchronously (in a thread from the thread pool), then thenApply will execute in that same worker thread.  This is in contrast to thenApplyAsync which always executes in a different thread from the ForkJoinPool.commonPool() (or a specified executor if provided).
         */
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return 5;
        }).thenApply(helloString -> helloString+" Shivam");


        /*
            thenAccept -> this is used when we don't want to return anything from the CompletableFuture<?> object. it will do some operation on the extracted value of the previous thread. We can also use it for chaining. This also has Async method, thenAcceptAsync and has similar logic to thenApply.

            It returns the completableFuture<Void>, this helps us in further chaining that does not uses the result of previous one.
         */
        CompletableFuture<Void> future2 = future1.thenAccept(helloString -> System.out.println(helloString));


        /*
        CHAINING THE OPERATIONS AND USING DIFFERENT THREAD POOL FOR DIFFERENT TASKS.
         */

        ExecutorService cpuBound = Executors.newFixedThreadPool(8);
        ExecutorService ioBound = Executors.newCachedThreadPool();

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        System.out.println("IO operation on thread: " + Thread.currentThread().getName());
                        Thread.sleep(500);
                        return "data from network";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, ioBound) // Use IO bound executor for network operations
                .thenApplyAsync(data -> {
                    // CPU intensive task (like data processing)
                    System.out.println("CPU processing on thread: " + Thread.currentThread().getName());
                    return data.toUpperCase() + " - PROCESSED";
                }, cpuBound)
                .thenApply(value -> {
                    System.out.println("Using the same thread as previous Async: "+Thread.currentThread().getName());
                    return value;
                })
                .thenAcceptAsync(result -> { // Use CPU bound executor for processing
                    // Another IO operation (like saving to database)
                    try {
                        System.out.println("Database operation on thread: " + Thread.currentThread().getName());
                        Thread.sleep(200); // Simulate database write
                        System.out.println("Final result: " + result);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, ioBound); // Use IO bound executor again

        // Wait for the chain to complete
        future.join();

        /*
        Exception Handling in CompletableFuture. The exceptionally block catches exception for any of the chained flow that is above it. It also returns CompletableFuture<?> object, so we can further chain it.
         */

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(helloString -> helloString+"Shivam")
                        .thenApply(helloString -> helloString+"Shivam")
                                .exceptionally(e -> {
                                    return ("Exception occured in above steps");
                                }).thenAccept(System.out::println);


        // Remember to shutdown executors when done
        cpuBound.shutdown();
        ioBound.shutdown();


    }

}
