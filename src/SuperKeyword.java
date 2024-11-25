

/*

1) If in a code, we provide a constructor with any number of arguments, java removes the default no arg constructor. So you need to explicitly write another no arg constructor.

2) Every class in java extends Object class.

3) About the Super Keyword

    1) Super() -> this will call the constructor of the immediate parent class ( By default, every constructor method has this written by default, until we change it)
    2) Super(arg1, arg2) -> This will call the parametrized constructor of the immediate parent class


 */


class ClassA{
    int a;

    ClassA(int a){

        this.a=a;
        System.out.println("This is the int constructor of A");
    }

    ClassA(){
        System.out.println("This is the no arg constructor of A");
    }

    void method(){
        System.out.println("Random method to check whether it can be called from the child using super");
    }
}

//when we extend a class, automatically
class ClassB extends ClassA{

    public ClassB(){
        super(5);
        System.out.println("Here is the constructor of B");
        super.method();
    }
}


public class SuperKeyword {
    public static void main(String[] args) {
        ClassB classB= new ClassB();
    }
}
