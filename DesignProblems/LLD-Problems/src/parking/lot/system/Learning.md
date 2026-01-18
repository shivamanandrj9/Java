1. First define the overall controller and its service like (BookingController, PaymentController), then when defining the methods in them, you will automatically figure out ki should we have separate service(entity driven where you will store List<> to replcate the db). Now think if this service is going to be called via UI, if no then no need to define the controller for that. 

2. For thread safety follow this

You will have a resource whose read, write you will need to manage thread safely.
Create one LockManagerClass -> This will own that resource storage in terms of List<>, HashMap etc and it will have the thread safe method to deal with those.
The service layer will then use those.

Now If you just have to deal with the resource which already is thread safe(and exposed thread safe method) like the ConcurrentHashMap, our previous work is already done. So just use it in the service layer directly.


5. Always think ki if we are using thread safe collections, do we need synchronized.
What was the issue when we were using the ConcurrentHashMap alone?
Reading in ConcurrentHashMap is allowed, so 2 threads could read the same slots that are occupied and then when they remove from all the free slots, they will see the same set of available slots and take the 0th one.

To solve these kind of problem, use concurrent queue that directly gives you the free slot atomically so that no two threads get the same slot.
ConcurrentLinkedQueue


6. Think of in terms of vehicle number, because vehicle object can be created at the time of entry. Better way is to ovverride the equals method that will be more better