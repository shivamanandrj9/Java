RULE OF THUMB:

**Java is always pass by value.**

so if we write 
`void methodName(Type xyz)`

that means xyz variable will copy whatever thing the caller passed.
so if the caller called methodName(pqr), then a new variable got created in stack with name xyz and whatever value pqr was holding in stack got passed to it.

Not coming the value being stored in stack, 
Primitive datatype -> Store the actual data in stack itself. i.e int x=5, then stack will store [x, 5].
Non-Primitive datatype -> Store the address of the data. The actual data is stored in heap and the address of that heap location is stored in stack. i.e. Integer x=5, then stack will store [x, 0x1123]

So whatever is held in stack is the thing that gets passed to this new variable name.

---
FYI: For Non-Primitive

When you use the dot operator (.) after a non-primitive variable (an object), you are essentially accessing the members (fields or methods) of the object that the reference variable points to in the heap memory.

---

Another Catch: Mutability and Immutability

All 8 wrapper classes for primitive types are immutable.
java.lang.Integer	Wraps the primitive int.
java.lang.Long	Wraps the primitive long.
java.lang.Double	Wraps the primitive double.
java.lang.Float	Wraps the primitive float.
java.lang.Boolean	Wraps the primitive boolean.
java.lang.Byte	Wraps the primitive byte.
java.lang.Short	Wraps the primitive short.
java.lang.Character	Wraps the primitive char.

So when you pass these in a method, the logic remains same that the reference is being passes as they are not primitive.

But if inside the method if you change their value, the variable actually switches the address or reference it was not. It will not go to the previous reference it was pointing to and change that.

So,

Will chaning the value changes the actual value of the passed ones?

| | **Primitive** | **Non-Primitive** |
| :---: |:-------------:|:-----------------:|
| **Immutable** |      NA       |        No         |
| **Mutable** |      No       |        Yes        |

(NPM)