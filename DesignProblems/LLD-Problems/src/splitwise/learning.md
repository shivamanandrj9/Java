1. Don't use softDelted until you have an usecase for audit.

2. Add fields like createdAt, createdBy, updatedAt, updatedBy and other things.

3. Use BigDecimal for storing money so that you don't get the floating precision error in double and float.'

4. Now if we want to show a simplified view, it is not always necessary to go via the backtracking approach. What we can do is we can have an entity like this 

groupId
userId
netBalance

Now we will store it in negative and positive values. 
when the user will request it, we will create two heaps(one for creditor and one for debitor). Then we will match the maximum ones (atleast one of them will cancel out in each of the step). This will reduce the number of transaction heavily.


5. When writing parameters for the methods in the service layer, you can take directly the things that are required and don't necessarily need to create a DTO for that. But we should ideally wrap the parameters in class (even subclasses inside that class as DTO) if there are more than 3 of them. Atleast convey this if you are not wrapping it to a class.


7. Returning id for the create resources are a good practice.

8. 