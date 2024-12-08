package InterfacesInJava;

/*

Lambda expressions are used for function interfaces.
 */

public class LambdaExpression {
    public static void main(String[] args) {

        FunctionalInterfaceImpl functionalInterface = (String name) -> {
            System.out.println("Hello " + name);
            return true;
        };

        System.out.println(functionalInterface.sayHello("John"));

    }
}
