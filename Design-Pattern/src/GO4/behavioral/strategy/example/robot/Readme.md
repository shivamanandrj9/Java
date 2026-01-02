Here we have group of algorithms like 

NormalTalk, NoTalk, NormalWalk, NoWalk, NormalFly, NoFly

Now we group these algorithms to a hierarchy under some abstract classes.

So basically fly karne ka 2 strategy hai, talk karne ka 2, walk karne ka 2.
Ab inko abstract kiya hai humne using interface which the objects like robot chan plug it depending on what they want.

Here the Robot abstract class is using composition to use multiple algorithm classes.

Robot abstract will be called Client.
