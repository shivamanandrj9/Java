/*


The basic difference between this and HashSet is that this also preserves the order.
It calculated the hash value of the elements that is going to be inserted and also stores the pointer of the node
 of the linked list containing this value. This way it preserves the order.

 Complexity is same as of HashSet.
 */


package Collections;

import java.util.LinkedHashSet;

public class linkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> hs=new LinkedHashSet<Integer>();

        //adding the elements
        hs.add(5);
        hs.add(14);
        hs.add(20);


        System.out.println(hs);

        hs.remove(14);

        System.out.println(hs);

        System.out.println(hs.contains(5));

        System.out.println(hs.isEmpty());

        System.out.println(hs.size());

        hs.clear();

        System.out.println(hs);
    }
}
