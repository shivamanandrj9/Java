package InterfacesInJava;

/*
    * Functional Interface is an interface that contains only one abstract method.
    * It can have any number of default, static methods but can contain only one abstract method.

 */

//works without the annotation as well
@FunctionalInterface
public interface FunctionalInterfaceImpl {
    boolean sayHello(String Name);

    default void defaultMethod(){
        System.out.println("This is a default method");
    }

    static void staticMethod(){
        System.out.println("This is a static method");
    }
}
