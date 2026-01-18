CAS -> Compare and Swap.

Example:

let’s use the example of incrementing a shared counter from 5 to 6.

1. Read: Thread A reads the memory and sees 5. 
2. Calculate: Thread A calculates $5 + 1 = \mathbf{6}$.
3. Atomic Exchange: Thread A tells the CPU: "If the current value is still 5, change it to 6. If not, tell me.
4. "Success: If no other thread changed it, the CPU updates the value to 6.
5. Failure (Retry): If Thread B changed it to 7 first, the CAS fails. Thread A reads the new value (7) and tries the whole process again.

Now till step 2, two threads can execute it parallely but while doing step 3.
"lock" happens.

Duration: It lasts for a single CPU instruction (nanoseconds).

The Mechanism: The CPU triggers a signal (like LOCK CMPXCHG on x86) that prevents other CPU cores from accessing that specific memory address for that tiny window.

Scope: It does not stop the thread or the OS; it only briefly freezes the "pathway" to that specific piece of data at the electrical level.