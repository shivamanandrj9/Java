# Data types

1. DateTime Related datatypes
    - Is it okay to use String in an interview. -> No, you will have to handle cases and validity checks.
    - use LocalDate, LocalTime -> methods that can be used are (LocalTime.now(), LocalTime.plusSeconds(), LocalTime.minusSeconds(), LocalTime.compareTo(). Similar for the date as well.)

2. primitive vs non primitive
    - For the entity definition, use Integer etc because since these fields will be auto increment and we would like to pass this as NULL so that db automatically assigns them a value.
    - For the service method, use Integer only so that you do a null check if the id is required and it has not been provided intead of assigning it a default value and messing the logic.

# Concurrency

1. When thinking of this that I will create a custom object to club the parameters on the basis of which lock will taken. We will create an interface of lock manager that will have acquireLock(), releaseLock(). Now this can be called in the service layer. Now this interface can have 2 implementation. 
    a. We go the usual way of having ConcurrentHashMap<LockingObject, ReentrantLock> and do it. but this has 2 problems.
        1. It can grow as there will be LockingObject that can grow based on some parameter that keeps on changing like here the date part. Solution is to use an executor service that will spin a thread at some specified intervals to clean up the values.
        2. In the distributed it can still fail. -> Solution is to use some layer to check the lock like the redis. This will create a variable lock and keep status of whether it is taken or not. The acquireLock() method definition will issue a query that if the lockStatus is false then make it true. This will solve the problem. Also the first problem will be solved by this only if we set a TTL.

2. Think about sloting and checking the locking status after sorting some kind of string generated for the slot. Like here roomId-YYYY-MM-DD-slotNumber. We can break the days into 30 mins slots.

3. For the above use cases we should always use tryLockWithTimeout

# WHAT IF?

2. If someone does not get any meeting room, our system notifies if the requirement is met.
3. How will the synchronization will work at DB level.

