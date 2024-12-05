/*

It uses a hash table for storing entries, similar to HashMap.
Additionally, it maintains a doubly-linked list to preserve the order of entries.

*/

package MapsInJava;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMaptut {


    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();


        linkedHashMap.put(3, "Charlie");
        linkedHashMap.put(1, "Alice");
        linkedHashMap.put(2, "Bob");
        linkedHashMap.put(4, "Daisy");

        // Getting an element
        System.out.println("Value for key 2: " + linkedHashMap.get(2));

        // Removing an element
        linkedHashMap.remove(4);
        System.out.println("After removing key 4: " + linkedHashMap);

        //Iterating over the map
        for(Map.Entry<Integer,String> entity:linkedHashMap.entrySet()){
            System.out.println(entity.getKey()+" "+entity.getValue());
        }

    }




}
