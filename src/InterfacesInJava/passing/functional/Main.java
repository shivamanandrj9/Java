package InterfacesInJava.passing.functional;

/*
Ek functional interface banaya jo ki kuch leta hai and kuch return karta hai

iska ek variable bana ke usme receipe define kar sakte hain using the lambda expression

Now us variable ko jaha man waha pass karo aur us functional interface ka method call kar sakte ho, to wo variable ka wo wala defined method call kar dega.
 */

public class Main {

    public static void main(String[] args) {

        FunctionInterfacePass var=(x)->{
            return 2*x;
        };
        //now we can pass this as variable to differnt methods.
        executeIt(var);

    }

    static void executeIt(FunctionInterfacePass var){
        System.out.println(var.doubleIt(10));
    }


    interface FunctionInterfacePass{
        int doubleIt(int val);
    }
}
