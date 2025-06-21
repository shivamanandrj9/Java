package creational.singleton.Lazy;

//Now the problem here is that since the object was not created during the start of the application. This will be taken care of by the threads that are serving the request. So if two parallel thread checks that the INSTANCE is null. Two instance will be created.

public class LazySingletonClass {

    private static LazySingletonClass INSTANCE;

    private LazySingletonClass(){}

    public static LazySingletonClass getInstance(){
        if(INSTANCE==null){
            INSTANCE = new LazySingletonClass();
        }
        return INSTANCE;
    }


}
