package Threading.ThreadSafeDataTypes.listInterface;

import java.util.ArrayList;
import java.util.List;

public class FailureOrArrayListExample {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        /*
        This will give the ConcurrentModificationException
        Reason: Behind this, Java has created an iterator to traverse this. If you modify this list in between directly, it will fail fast and throw exception to avoid ambiguity to how to handle the updated list during this read and any bugs that may arise because of this list modification. If you want to do it then do it via iterator. Check IteratingAList.java inside the iterator package.
         */
        for(String item: list){
            list.add("Guava");
        }

        /*
        This will work fine
         */
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("Mango")){
                list.add("Guava");
                list.remove("Apple");
            }
        }

        System.out.println("Updated list :" + list);
    }
}
