package CollectionsUsage.QueueInterface;

import java.util.ArrayDeque;
import java.util.Queue;

public class AsArrayDeque {

    public static void main(String[] args) {

        Queue<Integer> uq = new ArrayDeque<>();


        /*
        ELEMENT ADD METHODS
         */

        uq.add(5);

        /*
        ELEMENT REMOVE METHODS
         */
        uq.poll();

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
