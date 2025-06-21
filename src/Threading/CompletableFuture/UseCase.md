## Use Case ##

![](1.png)

In above, we want each of the independent flow to be sync but complete flow of placing order to be async.
If we do the above thing using the futures, we will do something like this:

![](Screenshot%202025-02-26%20at%201.00.42%E2%80%AFPM.png)
or we can define a callable method for each flow and do all these dependent things in that so that they run synchronously. But if we want to further divide any subtaskto async, it will be complex.


## Completable Futures ##

1. Thread() will create a new thread for our task, ExecutorService will create a pool of thread for our task. But if we don't want to create seperate thread pool, we can use a shared, globally available thread pool i.e. ForkJoinPool.commonPool(). When we don't pass any executor service to the CompletableFuture, it uses the ForkJoinPool wala pool for its task. 
It is a special type of thread pool designed for divide-and-conquer tasks.
It creates a pool of worker threads (typically equal to the number of available CPU cores).
It uses work-stealing, meaning if a thread finishes its task, it helps other busy threads by stealing their tasks.
