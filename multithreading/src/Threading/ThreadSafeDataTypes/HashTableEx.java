package Threading.ThreadSafeDataTypes;

import java.util.Hashtable;

public class HashTableEx {
    public static void main(String[] args) {
        Hashtable<String, String> ht=new Hashtable<>();

        /*
        This has all its methods synchronized. Bad concurrency
         */
    }
}
