public class wrapper_class {
    public static void main(String[] args) {
        //Every primitive data type has a wrapper class associated with it
        //int -> Integer
        //bool -> Boolean
        //double -> Double
        //... and so on.

        //these wrapper classes support auto-boxing and auto-unboxing
        //Example

        Integer a=5; //here we didn't do Integer a=new Integer(5). although we can do it.
        System.out.println(a);

        int b=a; //this is auto unboxing
        System.out.println(b);

        //these wrapper classes also provides some special methods
        //for example

        String p="10";
        int convertedValue=Integer.parseInt(p);
        System.out.println(convertedValue);
    }
}
