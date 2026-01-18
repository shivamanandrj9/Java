package Threading.ThreadSafeDataTypes;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueEx {


    /*
    1. It is unbounded, that means it can grow until we get OOM.
    2. This is similar to the LinkedList implementation of the queue, the only thing here it uses CAS.
    3. This is non blocking. In blocking queue example that we did, we saw that any poll operation(consumer) will wait until something is added. But here, we don't wait, we return null.
     */
    public static void main(String[] args) {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");
        System.out.println("After offers: " + queue);

        String head = queue.peek();
        System.out.println("Peek head: " + head);

        System.out.println("Queue size: " + queue.size());

        boolean hasBanana = queue.contains("Banana");
        System.out.println("Contains 'Banana'?: " + hasBanana);

        // Returns null immediately if empty (Non-blocking)
        String removedItem = queue.poll();
        System.out.println("Polled item: " + removedItem);
        System.out.println("Queue after poll: " + queue);

        // 7. Demonstration of empty behavior
        queue.clear(); // Also O(n) operation
        System.out.println("Polled from empty queue: " + queue.poll()); // Returns null
    }
}



