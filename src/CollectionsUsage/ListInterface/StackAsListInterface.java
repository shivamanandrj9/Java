package CollectionsUsage.ListInterface;

/*

This stack extends the vector class.

1) ADDING AN ELEMENT - O(1), ammortized, resizing ke time O(n)
2) FETCHING - O(1)
3) UPDATING - O(N)
4) DELETING - O(N), but last wale ke liye O(1)

 */

import java.util.List;
import java.util.Stack;

public class StackAsListInterface {
    public static void main(String[] args) {

        List<Integer> ls=new Stack<>();

        //adding an element
        ls.add(1);
        ls.add(3);
        ls.add(1);
        ls.add(3);

        //fetching
        System.out.println(ls.get(ls.size()-1));

        //deleting
        ls.remove(ls.size()-1);

        /*
        BUT WE DON'T GENERALLY USE IT BECAUSE IN THE IMPLEMENTATION OF STACK, ALL THE METHODS ARE SYNCHRONIZED AND IN A SINGLE THREAD ENVIRONMENT, WE ARE CONSTANTLY ACQUIRING AND RELEASING THE LOCK.

        Use ArrayDeque (Deque implementation) instead.
         */

    }
}
