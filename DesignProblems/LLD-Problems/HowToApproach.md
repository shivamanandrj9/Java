1. Requirement gathering 

   1. Think of participant (User, Admin or any group of person)
   2. Now write in plain english, what these will be doing. Try listing down everything. Think in terms of flow like (user will do this, then that).
   3. Keep open mind, can extend and ask about concurrency as well if you detect any happening.

2. List down core entities out of that.

3. Go ahead with the requirements or flow that was written and give each class(can be any utility class) and entities their responsibility. Define properties and methods.

   We will need these
   1. Entities (Always bottom up, see movie booking example)
   2. Controller
   3. Service (Each controller will have a service but vice versa is not true)
   4. Enum
   5. Interface
   6. Each interface ke liye impl package like ILockManager -> LockManagerImpl
   
   First define all the entities. Now go over the requirements one by one and go on filling controller, service, etc etc.

4. Think about concurrency if there is on how to handle it.
 
5. Think about design patterns (Make some common list based on experience that you can start thinking of leveraging)

6. While coding, maintain the design principles(SOLID, KISS, DRY, etc).

7. Now try to implement the important class first then move ahead with the other. If IDE based then keep adding the dependent class as per need which you have not defined yet but it is in your req otherwise if there is no time, you can go ahead with that class being implemented properly.