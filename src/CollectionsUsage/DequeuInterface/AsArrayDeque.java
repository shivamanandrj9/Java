package CollectionsUsage.DequeuInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsArrayDeque {
    public static void main(String[] args) {

        Deque<Integer> dq=new ArrayDeque<>();
        /*
        1. See the images about how they are implemented internally and their time complexity and you can choose between them. Behaviour remains the same thats why not coding

        Remember methods
        PPOCC -> Peek, Poll, Offer, Contains, Clear
        +
        PPO me First and Last lag jaega, like (PeekFirst, PeekLast, PollFirst, PollLast)
         */




        dq.offer(5);
        dq.offer(10);

        System.out.println(dq.peek());

        dq.poll();

        System.out.println(dq.peek());
        System.out.println(dq.contains(5));
        dq.clear();

        /*
        PUSH is equivalent to offerFirst.
         */



    }
}
