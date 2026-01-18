package Threading.ThreadSafeDataTypes;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> mp=new ConcurrentHashMap();

        /*
        This has multiple buckets which are being filled based on the hash value of the key.
        Reads does not lock any bucket
        Writes lock the bucket it is writing to
         */

        /*
        All the methods are same as regular HashMap
        REMEMBER:
        ConcurrentHashMap does not allow null keys or null values for one primary reason

         */
        mp.put("Hello","World");
        mp.put("Shivam", "Anand");
        mp.put("Rahul", "Chow");

        /*
        Be careful about the
        Slipped Condition
         */

        if(!mp.containsKey("Shivam")){
            mp.put("Shivam", "Patel");
            /*
            Two threads can reach here at the same time and will both put. This will override the previous key.
            Hence, instead of these, use below methods
             */
        }

        /*
        If the key is not present: it will return null
        If the key was present: it will return the previous value associated with that key and does not override.
         */
        mp.putIfAbsent("Neerav", "Patel");

        //If you want to compute something on the basis of key

        /*
        If the key is not present: it will return the computedValue
        If the key was present: it will return the previous value associated with that key and does not override.
         */
        mp.computeIfAbsent("Neerav", k -> {
            System.out.println("So this k is the same key that has been passed here i.e. Neerav. Whatever we return from here will become the value of this key");
            return "Patel";
        });

        //If you want to compute something on the basis of key
        mp.computeIfPresent("Neerav", (k,v) -> {
            System.out.println("So this k and v is the same key and value that has been passed here i.e. Neerav. Whatever we return from here will replace the value of this key");
            return "Patel";
        });


    }
}
