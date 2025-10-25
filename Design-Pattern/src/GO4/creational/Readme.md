1) This design pattern focuses on how objects are created.
2) It abstracts the instantiation process meaning it hides the details on how objects are created so that the code using the oject doesn't need to know the exact class or how it's build.

Example:-

```
Car car = new Car() <- direct creation


Car car = VehicleFactory.createCar(); <- We don't have the burden of its creation and other checks.

```