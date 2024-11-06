/*

Time Complexity:

O(log n) everything

min heap, max heap

 */

package Collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priority_queue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();


        pq.add(5);
        pq.add(15);
        pq.add(3);

        System.out.println(pq);


        System.out.println(pq.peek());

        pq.remove();

        System.out.println(pq);



        //To create a max heap priority queue, we need to pass a comparator.

        PriorityQueue<Integer> pq1=new PriorityQueue<Integer>(Comparator.reverseOrder());

        pq1.add(5);
        pq1.add(15);
        pq1.add(3);

        System.out.println(pq1);


        System.out.println(pq1.peek());

        pq1.remove();

        System.out.println(pq1);

    }
}
