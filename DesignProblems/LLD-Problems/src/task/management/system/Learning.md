1. We can have Model package where we can store pojo that is being used in entities like here if we would have defined List<Comment> comments and comment is like
Comment{
    String comment;
    String userId;
}

All the pojo, whenever required, will go to model.


2. List<Comment> vs Comment as separate table -> As a separate table. So that we can have pagination based logic + there is one to many relationship and hence we should have it towards the many side.

3. If something is defined as private and inside it we are having public, will that give compile time error?
-> We can define it but won't be able to access and it will break at compile time. Also we cannot have a top level class(the one which is the file name) as private in java. Inner classes can be private

4. Can we have same classes names in different packages? Yes

5. Injected classes should be private final like here voteLock and voteDao in LockingVoteManager.