package iterator;

import java.util.*;

public class IteratingAList {

    public static void main(String[] args) {
         /*
            We can iterate a list via an iterator as well.
         */

        List<String> list=new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        /*
        1. This is way 1 to traverse where you can remove wherever current iterator is pointing.
         */

        Iterator<String> itr=list.iterator();

        while(itr.hasNext()) {
            String val=itr.next();
            if(val.equals("Banana")){
                /*
                You can only remove the current element on which iterator is pointing
                 */
                itr.remove();
            }
        }

        /*
        1. This is way 2 to traverse where you want to add something while traversing.
         */

        ListIterator<String> lstItr=list.listIterator();

        while(lstItr.hasNext()) {
            String val=lstItr.next();
            lstItr.add("Mango");
        }

        System.out.println("Updated list: " + list);


    }

}
