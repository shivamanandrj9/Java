import java.util.Map;


/*
Map(Class) -> Entry(Nested Interface) -> KeyValueHolder(Class implementing Entry interface) -> entry(Method of class map that returns a keyValue Holder object)
 */

public class UsingPair {
    public static void main(String[] args) {
        Map.Entry<String,Integer> x=Map.entry("Ramesh",5);

        System.out.println(x.getKey());
        System.out.println(x.getValue());
    }
}
