/*


Normal deque jo hota hai c++ me
 */


package Collections;

import java.util.ArrayDeque;


public class deque {
    public static void main(String[] args) {

        ArrayDeque<Integer> dq=new ArrayDeque<Integer>();

        dq.addFirst(5);
        dq.addFirst(10);
        dq.addLast(-1);
        dq.addLast(30);

        System.out.println(dq);

        System.out.println(dq.peekFirst());
        dq.removeFirst();
        System.out.println(dq.peekLast());
        dq.removeLast();


        System.out.println(dq);

    }
}
