package CollectionsUsage.QueueInterface;

import java.util.ArrayDeque;
import java.util.Queue;

public class AsArrayDeque {

    public static void main(String[] args) {

        Queue<Integer> uq = new ArrayDeque<>();
        /*
        See the images about how they are implemented internally and their time complexity and you can choose between them. Behaviour remains the same thats why not coding

        Remember methods
        PPOCC -> Peek, Poll, Offer, Contains, Clear
         */


        /*
        ELEMENT ADD METHODS
         */

        uq.add(5); //throws IllegalStateException in case of breach
        uq.offer(5); //safe -> return true or false

        /*
        ELEMENT REMOVE METHODS
         */
        uq.remove();//throws NoSuchElementException in case of breach
        uq.poll(); //safe -> return null

        /*
        CHECK WHICH ELEMENT IS AT TOP
         */
        int val = uq.peek();

        /*
        GET SIZE
         */

        int size=uq.size();
        boolean isEmpty=uq.isEmpty();

        /*
        CLEAR
         */

        uq.clear();

        /*
        Check if the element exist
         */
        boolean isContained=uq.contains(5);


        /*
        NOTE: if we do Queue<Integer> bq = new ArrayDeque<>(10);  This results in a bounded queue. And it will throw IllegalState exception when we add extra element. So while adding we use bq.offer(x);
         */



    }
}
