package InterfacesInJava;

public interface BasicInterface {

    //by default, "public static final" is added to the variable because
    // 1. If it is not static then we need to create an instance of it before using it
    // 2. If it is not final then it can be changed by any means

    //this is fixed, we cannot have private or any other type properties in interface.

    public static final int variable=5;

    //By default the access specifier is public
    void sayHello();

    /* We can define a complete method(Full with implementation) in interface of following types:-
    1) Private
    2) Default
    3) Static
    */

    //private method
    private int helperMethod(){
        return 5;
    }

    //default method, it can be used in the class implementing this interface and can or cannot be overrided there.
    default int defaultMethod(){
        return helperMethod();
    }

    //static method
    static int doSum(int a,int b){
        return a+b;
    }

    //if we are defining any public method then it must be left abstract.

}
