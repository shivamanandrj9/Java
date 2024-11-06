package oops;


/*
Abstract methods -> Whenever we want to declare a method and the implementation of that method should depend
                    on the classes that inherit it based on the use-cases.

If a class contains an abstract method, we must declare that class also as an abstract class

Following are the properties of an abstract class
- We cannot create an object out of an abstract class
- If we are creating a concrete class out of an abstract class, we must override all the abstract methods.
- If we fail to override all the abstract methods, we must declare this new class an abstract class
- We can have implemented methods in an abstract class i.e. not necessary that all the methods needed to be
    abstract.
- If I have a made the abstract method declaration in the abstract class as protected, We must make it public
    or protected in the concrete class. Similarly, for public class, we must make it public while defining.
    Basically The rule is that the access level cannot be more restrictive than the abstract method's
    access level in the parent class.

 */


abstract class mobile{
    public void greet(){
        System.out.println("Hello there, this is a mobile phone");
    }

    abstract public void switchOn();

    abstract public void switchOff();

}


//creating a concrete class
class phoneA extends mobile{

    @Override
    public void switchOn(){
        System.out.println("Switch On Animation for phoneA");
    }

    @Override
    public void switchOff() {
        System.out.println("Switch Off Animation for phoneB");
    }
}

//creating another abstract class
abstract class phoneBrandX extends mobile{

    @Override
    public void switchOn(){
        System.out.println("BraneX Animation for switch On");
    }
}

//creating a concrete class using phoneBrandX abstract class

class phoneBBranX extends phoneBrandX{
    @Override
    public void switchOff(){
        System.out.println("Switch off animation for phone B");
    }
}


public class abstract_class {
    public static void main(String[] args) {

            phoneA a=new phoneA();
            phoneBBranX b=new phoneBBranX();

            a.switchOn();
            a.switchOff();


            b.switchOn();
            b.switchOff();
    }
}
