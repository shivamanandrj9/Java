wait(), notify(), and notifyAll() are defined in the java.lang.Object class, not the Thread class.

We know that any object can serve as a lock (monitor). Since threads wait on a specific "lock". We would like to deal with only those threads that are dealing with this lock object. So it makes sense to have these methods with the lock.

They allow threads to coordinate actions rather than just fighting for CPU time.


Now,

**obj.wait()** -> The thread that is holding this lock (basically the thread that got the lock and is executing) releases the lock so that other thread that are waiting for this lock use it meanwhile it sleeps. The current thread goes into WAITING state or TIMED_WAITING if we use obj.wait(1000). 

---
FYI:
If we used TIMED_WAITING, once it wakes up then
Conceptually: The thread goes to the Hub (RUNNABLE), tries to enter the door (Lock), finds it locked, and gets kicked to BLOCKED.
Practically (Java State): You will see the transition TIMED_WAITING $\rightarrow$ BLOCKED because the "Hub" step happens too deep inside the JVM native code to be registered as a Java state change.
---

**obj.notify()** -> Notifies one single random thread waiting on this object. Basically any one of the thread changes from WAITING -> BLOCKED -> RUNNABLE(Once it gets the lock, which it will)

**obj.notifyAll()** -> Notifies all the threads waiting for this lock
All of the threads will go to 
WAITING -> BLOCKED but only one will go the RUNNABLE. But as soon as the lock is released by the RUNNABLE one, other will jump to acquire the lock.

---

FYI: 

You can only safely use notify() if BOTH of these conditions are met:

1. All threads are waiting for the same condition.
2. They will do the same task.

---
In which case notifyAll() will waste the CPU?
Let's say there is a queue and all the threads are waiting for something to arrive on the queue to work on.
If an object arrives in the queue and it did lock.notifyAll(). All of the thread will move to the BLOCKED state from WAITING. Now only one will get the lock and process the queue's message. As soon as it is done. it will release the lock. Now since due to notifyAll() all the threads were pushed to the blocked state, now each one of them will be processed by CPU because while loop is there and again end up to waiting state. This will consume the CPU usage.

Assumed flow

synchronized(lock){
    while(q.size()==0) lock.wait(); //even if the thread acquires the lock it will again reverify if there is something in the queue and this will consume the CPU utilization;
    
    processess(q.peek());
    q.pop();

}

---

For the wait(timerValue), once woken up there is no way of knowing whether it got waked up via notify or via timer expiry.

In case of interruption we will know because we are bound to catch the checked exception of InterruptedException










