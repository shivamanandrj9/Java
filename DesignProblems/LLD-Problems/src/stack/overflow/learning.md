
---
Entity Design Learning:

1. post to comment is a one to many mapping. So we could just add the postId in the comments. No need for the mapping table. Same is done for the parent child comment relationship.

2. So for the comments to be chosen as the selected. This property we can keep it to the comments.

3. Tags can be a separate entity because tags can be created or removed. But for the interview purpose we can have it as enums.

---

DAO usage:

1. If you require join between two tables. So let's say you have two entities and you want col1 from first entity and col2 from second one both being joined by some key. You can call the dao of the first entity and get the objects with some conditions and in service layer itself you can filter or do something and call the dao of the second entity and expose one method there in the second entity's dao, that accepts those objects and give you the filtered ones. So basically you can do these thing in the service layer itself.

2. To handle any race condition, you can have a manager where it can have its inmemory data of its own if required. Also mention this
Per-key lock solves race condition only within one JVM. For real systems, rely on DB unique constraint / atomic insert as the final safeguard.

3. Problem Statement:
If there are 3 parameters to a function and you don't want to synchronize the whole function. You can do something like we did in the vote manager to have the synchronized logic only on the pararmeters that we want.

4. Inside the dao package. write VoteDao but keep it as interface. Actual impl should be inside the Impl package inside Dao. This will help you so that you can complete the impls later.

---

Writing Classes:

1. So always create an inner class like here VoteKey (just a data carrier) as static so that if you want to initialize it outside the class you will not have to mandatorily create a VoteManger object first.

2. So we might come up with the problem where we want to compare two objects with some custom logic, maybe just by comparing the parameter value. So we should override the equals and hashcode method like we have done for the VoteKey.
For comparing values of the datatypes like String, use Object.equals (This is already known)

3. We should lock here only on the basis of the userId and commentId. If we lock on the action as well. Same user can upvote and downvote for a given commentId. But like how we are doing in the LockingVoteManager for the 2 parameters, can be done for the 3 parameters as well if required.

4. enums can be compared by Objects.equals(enum1, enum2), and we can pass it too inside the Objects.hash(commentId, userId, action).

---

Design pattern 

1. Use Builder -> You can mark the annotation and start with it but know about how would you implement.

2. for event based some variable changes, we can use observer pattern.

3. Since comment and post both have some common thing like id, body, author, creationTime etc so we can think of creating one abstract class.
