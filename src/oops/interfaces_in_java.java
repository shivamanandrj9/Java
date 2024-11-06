package oops;

/*
1) In interfaces, all the methods are left undefined, and needed to be defined by the implementing concrete class.
2) We can create a reference of an interface and point it to the object of any class implementing it.
3) we use "implements" instead of "extends"
4) We can use multiple interfaces for creating a single concrete class or an abstract class.
    This can't be done with extending normal class or an abstract class.

5) while defining the methods of the interfaces in the concrete class, you must declare those methods as
    less restrictive than its parent. (Refer to abstract class file)

6) We can also have something like, class A extends class B implements Interface C.
7) we can also have properties like int a=5 etc. in an interface.
    But you cannot modify these properties anywhere as they are final by default.

8) We can extend one interface to create another interface.

9) You cannot declare an interface as protected or private. These access levels are not allowed for top-level interfaces because interfaces are intended to provide a contract that can be implemented by other classes, and restricting their visibility to protected or private would violate this principle.

10) In Java, when two interfaces (X and Y) have the same method signature (say, public void ma()), a class that
implements both interfaces (like temp) only needs to provide one implementation of the method, and that implementation will satisfy both interfaces.


11) In Java, an interface can only be declared as public if it is in its own file and the filename matches the
interface name otherwise it is default and you cannot change it.


***** Types of methods we can have in an interface *****
Check InterfaceD
1) Static Methods
    -> Since we can create reference of an interface and point it ot an object. We can take use of the static methods
    .It can also be used for properties(variables)

2) Default Methods
   -> Suppose we have used an interface at multiple places and now if i make changes to this interface, I will have to go to each of classes implementing this and change it.

   -> To tackle this we can add a default method and define it in the interface itself and wherever required we can just override it.

3) Private Methods
    -> We can have private methods as well but cannot access it in the class implementing it. This is just to provide
     us with the ease so that if our logic in the other methods get too much lengthy, we can put some of it in the
     private class.

 */



interface InterfaceA{
    void sayHello();
}

interface InterfaceB extends InterfaceA{
    int x=5;
    //public is redundant as interface declared itself is default
    public void sayHelloA(Integer x);
}

interface InterfaceC{
    void sayHelloC();
}

class concreteClass implements InterfaceB,InterfaceC{
    public void sayHello(){
        System.out.println("Hello from A");
    }



    public void sayHelloA(Integer y){
        System.out.println(y);
    }

    public void sayHelloC(){
        System.out.println("Hello from C");
    }
}


//*******************************************************************************

interface InterfaceD{

    //static
    static int val=10;
    static void sayHello(){
        System.out.println("Hello from the static");
    }

    //default
    default void defaultMethod(){
        System.out.println("This is my default method");
    }

    //private
    private void privateMethod(){
        System.out.println("This is my private method");
    }


}

class concreteClassB implements InterfaceD{



}

public class interfaces_in_java {
    public static void main(String[] args) {
        concreteClass A=new concreteClass();
        A.sayHello();
        A.sayHelloA(64);
        A.sayHelloC();

        concreteClassB B=new concreteClassB();
        System.out.println(B.val);

    }
}
