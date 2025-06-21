package creational.prototype.WithoutUsingCloneInterface;

import creational.prototype.Person;

public class PersonA implements Cloneable {
    private String name;
    private int age;

    public PersonA(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return this.name;
    }

    /*
    Every Java class implicitly extends Object if it doesn't explicitly extend another class
    The Object class has a clone() method that performs a shallow copy of an object
    The Cloneable interface is a marker interface (has no methods) that simply indicates to the JVM that a class allows cloning (Lagao mat lagao, fark nahi padta).
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
