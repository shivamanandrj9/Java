### Usecase of Injector ###


1) By using Guice, we can get instance of any class by using *injector.getInstance(DrawRequest.class);*. The flow works in this way. First it will check whether there is any binding present in the *ShapeModule* for DrawRequest class. If it is present then it will try to create an instance for that class instead of the Shape Module class. Now while creating, it will check which constructor of that class has *@Inject* annotated to it. It will use that constructor. Now if the constructor is asking for any class again to instantiate any of its interface for its object creation, it will again refer to the *ShapeModule* to check for its concrete implementation(a class) binding and proceed by creating that.


2) Let's say my constructor with @Inject has *String color* as one of its argument. We can again define this binding in *ShapeModule* as *bind(String.class).toInstance("Maroon")*. But this will be used anywhere where the string is used as an argument in the constructor annotated with *@Inject*. To tackle with this, we create custom annotations. [Reference](https://www.youtube.com/watch?v=xfeEjAj2Rgs&list=PLp0ed20U4R4jknb4xYdhx3yJn5RhWECxn&index=9).


3) If we want an instance to be singleton, i.e calling the *getInstance* always give us the same object. We can put in the binding file(ShapeModule) *.in(Scopes.SINGLETON)*. Remember, If any class has another class as a variable in it then it will not automatically be singleton. It must again be assigned with *.in(Scopes.SINGLETON)*. [Reference](https://www.youtube.com/watch?v=xwrWzlNxbGY&list=PLp0ed20U4R4jknb4xYdhx3yJn5RhWECxn&index=11).


4) Method Injection: In method injection, We don't put @Inject over a constructor like we did in DrawRequest class. We can put inject over any method to initialize the variable. The flow will be that the Guice will first use noarg const to create an object for that class and then it will use the *@inject* annoted method A and execute what we have written. The args in the method A will again be dereferenced by Guice as was in the case of constructor. Example: In DrawRequest class, we can do.


```
@Inject
public void setDrawShape(DrawShape d)
{
    this.d=d
}
```


5) Field Injection: We can simply put @Inject over the variable *public DrawShape drawShape;* . It will automatically first create object using the no arg const then use the binding file *ShapeModule* in this case to inject class of DrawShape implementation.



