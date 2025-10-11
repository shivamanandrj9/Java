/*
1. We can have private method and properties inside the abstract class.
2. We don't necessarily need abstract method within a class to call a class abstract.
 */

package AbstractClassInJava;

abstract class AbstractParentClass {
    private int priValue;
    public int pubValue;

    abstract void hello();

    private void privateHello(){
        System.out.println("Hello from private");
    }
}

class ChildClass extends AbstractParentClass{
    void hello(){
        System.out.println("Hello World");
    }
}


public class AccessSpecifierInAbstractClass{
    public static void main(String[] args) {
        ChildClass childClass=new ChildClass();
        childClass.pubValue=5;
        System.out.println(childClass.pubValue);
    }
}
