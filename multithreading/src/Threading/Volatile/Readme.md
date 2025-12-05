In actual program execution, the cpu copies the variables from the RAM to the L1/L2 cache or registers for fast access.

Now when a program tries to update a variable, the flow is that it first changes the value in the cache and then goes ahead and update to the main memory. 

Now during this interval, there might be another thread under execution and it will be having its own cache which is still having the previous state of that same variable.

To save from this, we use volatile keyword before those variable where we have the risk of this thing and force the CPU to directly read and write from the main memory and not to the cache. 


Example:

```

public class DoubleLockingSingletonClass {

    private static **volatile** DoubleLockingSingletonClass INSTANCE;

    private DoubleLockingSingletonClass(){}

    public static DoubleLockingSingletonClass getInstance(){

        if(INSTANCE == null){

            synchronized (DoubleLockingSingletonClass.class){

                if(INSTANCE == null){
                    INSTANCE = new DoubleLockingSingletonClass();
                }
            }
        }
        return INSTANCE;
    }
}

```