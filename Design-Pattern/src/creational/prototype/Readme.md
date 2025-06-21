A Prototype is a creational design pattern that lets you copy existing objects (“prototypes”) instead of creating new ones from scratch, which can be more efficient or flexible when object setup is costly or complex.

Complex meaning there are 100s of properties of that class like name, age etc.
Costly meaning that some variable that it holds came after a large calculation that is computationally heavy so it is good idea to just clone it.


## Deep Copy vs Shallow Copy ##

Shallow Copy -> It will create a new object but if the objects properties contains any reference class objects like(List, Map, anyother class), the new cloned object created will just point the properties created for the cloned to the previous properties.

Deep Copy -> It will not point the reference but create a seperate object for each of the properties of the class.