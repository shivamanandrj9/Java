/*

This is basically the set that we use in C++.

add(): O(logN)
remove(): O(logN)


 */

package CollectionsUsage.SetInterface;

import java.util.TreeSet;

public class treeSet {
    public static void main(String[] args) {
        TreeSet<Integer> ts=new TreeSet<>();

        ts.add(5);
        ts.add(-1);
        ts.add(40);

        System.out.println(ts);

        ts.remove(40);

        System.out.println(ts);

        System.out.println(ts.contains(5));

        System.out.println(ts.isEmpty());

        System.out.println(ts.size());

        ts.clear();

        System.out.println(ts);
    }
}
