package Threading.ThreadMethods;

public class InterruptionExample {
    public static void main(String[] args) {

        // 1. Create a thread (The "Worker")
        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker: I am going to sleep for 10 seconds...");
                Thread.sleep(10000); // Sleeping
                System.out.println("Worker: Woke up naturally.");
            } catch (InterruptedException e) {
                // 3. This block runs when interrupted
                System.out.println("Worker: I was interrupted! Stopping now.");
            }
        });

        worker.start();

        // 2. Interrupt that specific thread from Main
        try { Thread.sleep(2000); } catch (InterruptedException e) {} // Wait a bit
        System.out.println("Main: Hey Worker, wake up!");

        worker.interrupt(); // <--- This interrupts the specific 'worker' thread
    }
}
