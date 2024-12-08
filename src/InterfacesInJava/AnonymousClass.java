package InterfacesInJava;
/*

We can create an object of an interface using an anonymous class. We do not need to define a class, we just need to create an object and define the abstract methods then and there.
 */

public class AnonymousClass {

    public static void main(String[] args) {

        BasicInterface obj=new BasicInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };

        System.out.println(obj.defaultMethod());
        obj.sayHello();
        System.out.println(BasicInterface.doSum(5,7));
    }



}
