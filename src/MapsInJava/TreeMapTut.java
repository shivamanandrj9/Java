/*

TreeMap is implemented using the red black tree. Just like the normal map that we use in c++.

put(K,V) -> O(logn)
get(K) -> O(logn)
remove(K) -> O(logn)
containsKey(K) -> O(logn)



 */


package MapsInJava;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTut {


    public static void main(String[] args) {
        TreeMap<String,Integer> map=new TreeMap<>();

        //inserting the values
        map.put("Shivam",20);
        map.put("Rahul",21);
        map.put("Rohit",22);

        //getting a value
        System.out.println(map.get("Shivam"));

        //removing a value
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
