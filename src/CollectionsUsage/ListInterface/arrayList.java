/*

Time Complexities:

add -> O(1)
get -> O(1)
remove -> O(n)

Normal array operations

 */




package CollectionsUsage.ListInterface;

import java.util.*;


public class arrayList {
    public static void main(String[] args) {
        //These are just like vectors
        //since it uses oops.generics, we can only use wrappers

        ArrayList<Integer> arr=new ArrayList<Integer>();

        //pushing the elements
        arr.add(5);
        arr.add(3);
        arr.add(7);
        arr.add(8);

        //accessing the elements
        System.out.println(arr.get(0));
        System.out.println(arr.get(2));

        //updating the value at index i
        arr.set(1,14);

        //pushing an element at a given position
        arr.add(1,4);

        //soting the array
        Collections.sort(arr);
        System.out.println(arr);

        //reversing the elements in arraylist
        Collections.reverse(arr);
        System.out.println(arr);

        //removing an element
        arr.removeLast(); //removes the last element
        arr.remove(2); //removes using an index


        //Iterator (Many functionalities)
        Iterator<Integer> itr=arr.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
}
