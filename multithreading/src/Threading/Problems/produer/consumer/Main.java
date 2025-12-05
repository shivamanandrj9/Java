package Threading.Problems.produer.consumer;

public class Main {

    public static void main(String[] args) {
        // Create a BlockingQueue with a capacity of 5
        BlockingQueue sharedQueue = new BlockingQueue(5);

        // --- Producer Thread ---
        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    sharedQueue.addElement(value++);
                    // Sleep to simulate time taken to produce an item
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        // --- Consumer Thread ---
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    sharedQueue.removeElement();
                    // Sleep to simulate time taken to process/consume an item
                    Thread.sleep(1000); // Slower consumer to force "Queue Full" scenario
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        // Start the threads
        producer.start();
        consumer.start();
    }
}