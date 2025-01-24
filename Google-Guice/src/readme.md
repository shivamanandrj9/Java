### Usecase of Injector ###


1) By using Guice, we can get instance of any class by using *injector.getInstance(DrawRequest.class);*. The flow works in this way. First it will check whether there is any binding present in the *ShapeModule* for DrawRequest class. If it is present then it will try to create an instance for that class instead of the Shape Module class. Now while creating, it will check which constructor of that class has *@Inject* annotated to it. It will use that constructor. Now if the constructor is asking for any class again to instantiate any of its interface for its object creation, it will again refer to the *ShapeModule* to check for its concrete implementation(a class) binding and proceed by creating that.


2) Let's say my constructor with @Inject has *String color* as one of its argument. We can again define this binding in *ShapeModule* as *bind(String.class).toInstance("Maroon")*. But this will be used anywhere where the string is used as an argument in the constructor annotated with *@Inject*. To tackle with this, we create custom annotations. [Reference](https://www.youtube.com/watch?v=xfeEjAj2Rgs&list=PLp0ed20U4R4jknb4xYdhx3yJn5RhWECxn&index=9).




