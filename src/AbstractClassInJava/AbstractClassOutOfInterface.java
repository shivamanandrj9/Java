/*
If we are creating an abstract class out of interface, then those methods are abstract methods. An abstract class that implements an interface is not required to provide an implementation for the interface's methods. The implementation is instead delegated to any non-abstract (concrete) class that extends the abstract class.
 */

package AbstractClassInJava;

public abstract class AbstractClassOutOfInterface implements MyInterface {

}

interface MyInterface{
    void method();
}

class ConcreteClass extends AbstractClassOutOfInterface{
    @Override
    public void method(){
        System.out.println("This method is called");
    }
}
