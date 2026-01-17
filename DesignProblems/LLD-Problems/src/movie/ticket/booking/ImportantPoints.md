1. ALWAYS CLARIFY WHETHER WE ARE GOING TO SHOW THE WHOLE INTERFACE LIKE, ON CONSOLE DO YOU WANT IT TO HAVE OPTIONS LIKE SELECT A MOVIE, SELECT A SEAT, ETC, ETC

2. OR IN CASE OF THREADING PROBLEM, THINK OF JUST A FUNCTION CALL WILL BE HAPPENING FROM THE MAIN AND THREAD SAFE HANDLING WILL BE DONE INTERNALLY SOMEWHERE. YOU CAN START THINKING IN THIS WAY FIRST IN THREAD RELATED PROBLEMS AND LATER ADD THE LAYER, TELL THE INTERVIEWER. 

3. How the lock will be taken for a configurable time and how the notification will go?

----
POST IMPLEMENTATION POINTS

1. We have 2 ways to handle the locking:

   1. We can use sorting and then use the reentrant lock to lock it or unlock it. (this is more scalable)
   2. Use synchronized over the show itself, check the seat states, update the state of the seat. (This will cause issue, let's say each booking takes 0.2 sec to move to payment stage and 1000s of user are doing it parallely, since we are taking a show level lock, the last thread might have to wait for 0.2*1000 = 200 secs).


2. Either we associate a the lock with the Seat itself, of create a layer of locking manager that will store all the lock mappings of a seat. But Always use thread safe data structures like ConcurrentHashMaps to deal with it. 
Here in our case since I want to also keep track of when it got locked, I need to create a separate lock associated with the seat.


----

1. You should think like in terms of entity and then if you need some relationship like here show and seat. Just create another entity. 
Let's say you want the status of the seat, but without knowing the show, we won't be able to tell if that seat is booked or not. So we will create one booking entity. that will store all the (seat-show bookings). Think in terms of how would have stored it in the database.