/*

Just to keep single occurrences of each element.

***Average Complexity***
add() -> O(1)
remove() -> O(1)
contains() -> O(1)

***Worst Complexity***
For all the operation it will be O(n).




basically it just checks whether the hash value of given element already exists or not. If it exists then it does not
 add the element. Same as unordered_map in c++.


 */


package Collections;


import java.util.HashSet;

public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> hs=new HashSet<Integer>();

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
