package generics;

public class GenericExecutor {

    public static void main(String[] args) {
        GenericClass<Integer, String, Double> c=new GenericClass<>(); //Bas initiate karte time <> iski jarurat hogi, rest you can use directly without <> wherever required in method parameter.
        c.var1=1;
        c.var2="Hello";
        c.var3=0.5d;

        printObject(c);

    }

    static void printObject(GenericClass x){
        System.out.println(x.var1+ " "+ x.var2 + " "+x.var3);
    }
}
