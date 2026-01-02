Rule of thumb: We need Thread Class and call its Thread.start() to spawn a thread.

Now, the Thread class have two important things


1. It is an implementation of Runnable(a functionInterface). That means it will definitely have a run() method implementation inside it. 
By default, the run() method that is implemented in there basically calls the .run() of another class (private Runnable target) which is again an implementation of Runnable.



2. .start() method that it have indirectly calls this run() method implementation.
   **USE START() to start a thread, don't use RUN()**

So there are two ways to instantiate a thread

1. We provide a class that is implementing the runnable so that it can be substituted to target. Initially the target is null and calling Thread.start() will do nothing(because Thread.start() will call Thread.run() and it will then call target.run()). Check viaTarget.java
2. We create one class extending Thread class and override the run() method directly. Basically skipping the extra flow of calling target.run(). Check viaOverride.java


FYI:
But we generally avoid the 2nd approach as it is extending a class and in Java we can extend only one class and this restricts our design. So we use 1 as we can implement multiple interfaces.


