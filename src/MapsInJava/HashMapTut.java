// It implements the Map interface.

//Time complexity

/*

put(K,V) -> Avg O(1), Worst O(n)
get(K) -> Avg O(1), Worst O(n)
remove(K) -> Avg O(1), Worst O(n)
containsKey(K) -> Avg O(1), Worst O(n)


* Iteration

HashMap does not guarantee the order of keys or entries during iteration. The iteration order depends on the internal hashing mechanism and the bucket allocation.

HashMap maintains these three sets internally: keys, values, or key-value pairs.pairs, which we can get using the keySet(), values(), and entrySet() methods, respectively.

Map.Entry() is an inner interface of Map, which is used to represent a key-value pair stored in a Map. It provides methods to get the key and value.


*/


package MapsInJava;

import java.util.HashMap;
import java.util.Map;

public class HashMapTut {

    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();


        //inserting the values
        map.put("Shivam",20);
        map.put("Rahul",21);
        map.put("Rohit",22);

        //getting a value
        System.out.println(map.get("Shivam"));

        //removing a value
        /*
        If a key is not present, it will return null else it will return the value.
         */
        map.remove("Rohit");

        //checking if a key exists
        System.out.println(map.containsKey("Rahul"));

        //Iterating over the map
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //Iterating over the keys
        for(String key:map.keySet()){
            System.out.println(key);
        }

        //Iterating over the values
        for(Integer value:map.values()){
            System.out.println(value);
        }


    }

}
