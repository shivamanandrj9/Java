/*

Difference between vector and arrayList

1) Vector increases its size by twice everytime, it exceeds its size. While an arrayList increases by half of the current size
2) Vector is thread safe, Array list is not thread safe
3) Vector is slow, ArrayList is fast.

 */


package Collections.ListInterface;

import java.util.*;

public class vectorInJava {


    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();

        //add
        v.add(5);
        v.add(6);
        v.add(10);


        //get
        for(int i=0;i<v.size();i++)
        {
            System.out.println(v.get(i));
        }

        //update
        v.set(1,15);

        //delete
        v.remove(1);

        System.out.println(v);

        Collections.sort(v);


    }
}
