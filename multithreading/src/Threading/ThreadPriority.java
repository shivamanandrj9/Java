package Threading;

public class ThreadPriority {
    public static void main(String[] args) {

        // 1. Define the work: A loop that prints the thread name
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                String threadName = Thread.currentThread().getName();
                int priority = Thread.currentThread().getPriority();
                System.out.println(threadName + " (Priority: " + priority + ") is running count: " + i);
            }
        };

        // 2. Create Threads
        Thread t1 = new Thread(task, "Low-Priority-Thread");
        Thread t2 = new Thread(task, "Mid-Priority-Thread");
        Thread t3 = new Thread(task, "High-Priority-Thread");

        // 3. Set Priorities (Range is 1 to 10)
        t1.setPriority(Thread.MIN_PRIORITY);  // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5 (Default)
        t3.setPriority(Thread.MAX_PRIORITY);  // 10

        // 4. Start them
        // Note: We start low priority first to give it a head start,
        // to see if High priority overtakes it.
        t1.start();
        t2.start();
        t3.start();

        /*
        Setting priority is a "hint" to the Scheduler. The OS (Windows/Linux/Mac) has the final say. On powerful multi-core CPUs, lower priority threads might still run simultaneously with high priority ones. So the scheduling of the thread will be taken care of by jvm which indirectly depends on the system it is running.


         */
    }
}
