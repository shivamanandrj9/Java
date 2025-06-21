The circuit breaker design pattern is used for distributed systems and microservices. Its primary goal is to prevent a system from repeatedly trying to execute an operation that's likely to fail, which can lead to resource exhaustion and cascading failures.

-----------FYI BOX 1----------
Resource Exhaustion:- When the threads waits for an I/O, it is sent to the waiting state by the OS. It is not allocated the CPU while it is in waiting state. Even though present in the waiting state, the thread continues to occupy the resources like the stack memory, heap memory etc. Let's say multiple threads are making the calls to some external service that is failing continuously, all these resources will be wasted until it is timed out.

Cascading Failures:- Let's say service A calls service B as one of its usecase. Now service B is failing continuously. If there are multiple threads that stays waiting for service B to respond. Service A might also become slow and in the worst case stops working if there is no thread pool set for that specific service B call. This can lead to service A failure as well.

----------------------------

-----------FYI BOX 2----------
If the CPU ignores these waiting state processes, how does it come to know if the I/O operation is complete?

Interrupt-Driven Notification:
When an I/O operation is initiated, the thread enters a waiting state. The I/O device performs its task independently and, once completed, sends an interrupt signal to the CPU. This interrupt alerts the operating system that the I/O operation has finished.
----------------------------