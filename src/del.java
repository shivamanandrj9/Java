import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

public class del {
    public static void main(String[] args) {

        ArrayList<Map.Entry<String,Integer>> x=new ArrayList<>();

        x.add(Map.entry("Shivam",5));
        x.add(Map.entry("Rohan",10));

        x.sort((a,b)-> a.getValue()-b.getValue());
        System.out.println(x);


    }


}

class comparator{

}

