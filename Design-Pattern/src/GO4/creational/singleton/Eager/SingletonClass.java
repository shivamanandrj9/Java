/*
Here the object of this Singleton class gets created while the program starts.
Now if we are doing some changes to the value in multiple requests, this will send us in race condition as the val has been created in the memory at the start of the application and all the parallel request threads are accessing it simultaneously.
*/


package GO4.creational.singleton.Eager;

public class SingletonClass {

    private int val=5;
    private static final SingletonClass INSTANCE = new SingletonClass();


    private SingletonClass(){

    }

    public static SingletonClass getInstance(){
        return INSTANCE;
    }

    public int getVal(){
        return val;
    }

}
