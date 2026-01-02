This is a behavioural pattern where an object (Subject) maintains a list of dependents (Obeservers) and notifies them automatically of state changes.

Rule of thumb:
If there is some change that take place in an object (it can be a property change or a method getting called of this object, anything) and based on the changes many objects must react to it (maybe logging, metrics or any other things). Think about this pattern.

How to solve it.

1. Create one Observer interface
2. Create one Subject interface
3. Create one pojo that will carry your data, basically the contract that will get communicated from the subject to the observer.

See example.

In case of multiple subjects to be observed by single observer. Think about designing the contract to have the identifier on which is the one notifying and then update() method can handle it accordingly.