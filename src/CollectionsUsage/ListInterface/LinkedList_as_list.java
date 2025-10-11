//Time complexity - It is a doubly linked list, so if we give the index, it will fetch by traversing it.

/*

ADDING ELEMENT

- front O(1)
- back O(1)
- At any index O(n)

FETCHING ELEMENT

- O(n)

UPDATING AN ELEMENT

- O(n)

DELETING AN ELEMENT

- front O(1)
- back O(1)
- At any index O(n)



 */


package CollectionsUsage.ListInterface;

import java.util.*;

public class LinkedList_as_list {
    public static void main(String[] args) {
        List<Integer> ls=new LinkedList<>();

        //adding element

//        ls.addFirst(1);
//        ls.addFirst(2);
//
//        ls.addLast(3);
//        ls.addLast(4);

        ls.add(1,10);


        //reading the element

        System.out.println(ls.get(2));

        //Updating the element
        ls.set(3,120);

        //deleting an element
        ls.remove(2);

        System.out.println(ls);


    }
}
