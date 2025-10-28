We need synchronization to deal with the race conditions. 

**We can synchronize by using locks on**
1. Any critical section inside the code
2. Any method

**How to do it?**

1. For 1, we can use any object as lock, we need to pass it as parameter to synchronized. `synchronized(obj){<critical section>};`
2. In case of method, the current class objects is used. Basically under the hood it does 
`synchonized(this){<whole method>}`.
3. In case of static method, the mirroring is used and under the hood it does
   `synchonized(ClassName.class){<whole method>}`.

But for 2 and 3. We don't need to worry, just put synchronized in the method signature, it is handled automatically.

`public synchronized int methodName(){}`

NOTE: Whatever object that is getting passed within synchronized as lock, if used in two or more places. If the lock is hold at one place, then at other places, the threads will not be able to access it. 


When a subclass overrides a method inherited from a superclass, the subclass must explicitly use the synchronized keyword in its new method definition if it wants the overriding method to also be synchronized. Synchronization is not inherited with the method.