1. We can have Model package where we can store pojo that is being used in entities like here if we would have defined List<Comment> comments and comment is like
Comment{
    String comment;
    String userId;
}

All the pojo, whenever required, will go to model.


2. List<Comment> vs Comment as separate table?

3. If something is defined as private and inside it we are having public, will that give compile time error?

4. Can we have same classes names in different packages? Should be yes;