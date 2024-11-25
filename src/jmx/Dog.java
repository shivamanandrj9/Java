package jmx;

import java.io.Serializable;

public class Dog implements Serializable,DogMBean {
    private int age = 10; // Set a default age
    private String name = "Fido"; // Set a default name

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int newAge) {
        this.age = newAge;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public void bark() {
        System.out.println("Woof");
    }
}
