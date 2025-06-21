package creational.singleton.Synchronized;

public class SyncSingletonClass {
    private static SyncSingletonClass INSTANCE;

    private SyncSingletonClass(){}

    //the synchronized keyword applies a lock to this method so, only one thread can be executing this method at a time. This solves our problem with Lazy.
    //So due to locking, it is slow in serving the requests.

    synchronized public static SyncSingletonClass getInstance(){
        if(INSTANCE==null){
            INSTANCE = new SyncSingletonClass();
        }
        return INSTANCE;
    }
}
