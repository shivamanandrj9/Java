In actual program execution, the cpu copies the variables from the RAM to the L1/L2 cache or registers for fast access.

Now when a program tries to update a variable, the flow is that it first changes the value in the cache and then goes ahead and update to the main memory. 

Now during this interval, there might be another thread under execution and it will be having its own cache which is still having the previous state of that same variable.

To save from this, we use volatile keyword before those variable where we have the risk of this thing and force the CPU to directly read and write from the main memory and not to the cache. 

---
When you use synchronized(lock), the Java Memory Model (JMM) enforces two strict rules:

On Entry (Taking a lock): The thread invalidates its local cache and is forced to read the latest values from the main memory.

On Exit (Releasing a lock): The thread flushes all its local changes (like q.size()) back to the main memory so other threads can see them.

But if you read the same variable twice inside the synchronized block, the second time read will be from cache, the reason is that since we are already in the synchronized block, jvm assumes that no other thread will be changing it.

---


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