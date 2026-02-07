CHILLAX (Don't get stuck by the rules)


1. Visualize user, admin flow and write every requirements.

2. Read the requirements -> List down entities -> Think about association between the entities(1:1 , 1:Many, Many:Many) and write attributes
1:1 -> Think about which will exist independently.
1:Many -> Include 1 side of entity to the many one
Many:Many -> Create a mapping

3. Mention Controller, Service, Interface, Enums.
Flow: Controller ---will have---> Service -----will use----> Manager

4. Read the requirement, write the methods in service layer then put it in service class. Include List<Entity> in respective service class. You can use methods if you want to service's List<Entity>.

5. Eventually we will need a Manager either for handling concurrency or core logic.




### NOW PRACTICE ###






















At some point you might realise that you need a core manager (For concurrency, it is a must). Create its interface and impl, add methods that will be required there and think deep. Most of the time, you will have your own thread safe data structure to keep track of locking etc which will be there in the Manager and for other entity access you can directly call the service layer.

But feel free to move that List<Entity> to booking manager if use case required. In case of cyclic dependency, like service X want to access the manager's method Y, but manager want to access your entity. Move this method from service X to separate service.

5. This manager and services will be singleton.

6. For writing concurrency logic, you will write it in the manager. Don't create another layer. Either use the concurrent data structures or handle via synchronized etc. Let's say you want to deal conccureny with an entity but you have already defined it in a separate service with its own list, don't touch that. Handle whatever you want to do in the manager only, safe the method calls in here only.

NOTE: DON'T BOUND YOURSELF. IF YOU WANT TO THINK DEEP EVEN WHEN WRITING ENTITIES, DO THAT. DON'T STOP YOURSELF. ALSO THE ABOVE RULES ARE NOT HARD AND FAST, YOU CAN ANYWAY DO IT AND DON'T HESISTATE TO CHANGE AS PER NEED.
---------------------------

7. Now try to implement the important class first then move ahead with the other. If IDE based then keep adding the dependent class as per need which you have not defined yet but it is in your req otherwise if there is no time, you can go ahead with that class being implemented properly.