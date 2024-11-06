/*

Linked list has implemented both the interfaces which is List and Queue.
Hence both of the interfaces methods can be used here and the complexities are:

Queue Interface Methods:

add() -> O(1)
offer() -> O(1) -> Throws exception

peek() -> O(1)
element() -> O(1) -> Throws exception

Poll() -> O(1)
Remove() -> O(1) -> Throws exception


List Interface Methods:

add(): O(1)
add() (at specific index): O(n)

set (at specific index): O(n)

removeLast() : O(1)
remove(index_val) : O(n)



 */


package Collections;

import java.util.LinkedList;

public class Linked_list_as_Queue {
    public static void main(String[] args) {

        //Queue Implementation

        LinkedList<Integer> list=new LinkedList<Integer>();
        list.add(5);
        list.add(10);
        list.add(15);

        System.out.println(list);


        System.out.println(list.peek());

        list.remove();

        System.out.println(list);



        //List Implementation

        list.add(20);
        list.set(0,420);
        list.removeLast();

        System.out.println(list);


    }
}
