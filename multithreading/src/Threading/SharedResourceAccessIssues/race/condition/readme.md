1. It occurs when two or more threads attempt to access and modify the same shared data simultaneously.
2. The output of a program depends on the unpredictable sequence or timing of operations executed by multiple threads.

3. The segment of code where the shared resource is accessed and modified is called the Critical Section. Any time multiple threads can enter a Critical Section simultaneously, a Race Condition is possible.
4. To prevent Race Conditions, you must ensure that only one thread at a time can execute the Critical Section. Synchronization.