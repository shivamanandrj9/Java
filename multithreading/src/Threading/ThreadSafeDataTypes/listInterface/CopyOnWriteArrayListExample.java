package Threading.ThreadSafeDataTypes.listInterface;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    /*
    1. Any write operation on this array (adding or removing the element), it acts on a new version of that array and once done the current position is changed to this version.
    2. Meanwhile, the write operation is not done, the read will happen on the previous version.
    3. Useful in read heavy environment.
     */

    public static void main(String[] args) {


        List<String> shoppingList = new CopyOnWriteArrayList<>();

        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");

        for(String item: shoppingList){
            if(item.equals("Eggs")){
                shoppingList.add("Butter");
            }
        }

        System.out.println("updated list: "+shoppingList);
    }
    
}
