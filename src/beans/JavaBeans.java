package beans;/*

A JavaBean is a simple Java class that follows certain conventions and is primarily used as a reusable software component. Any class following the below properties can be classified as a java beans.

1) All properties in a JavaBean must be private with public getters and setter methods.

2) beans.JavaBeans usually have a no-argument constructor to allow easy instantiation.

3) beans.JavaBeans often implement the Serializable interface to allow their instances to be saved and restored. When an object is serializable in Java, it means it can be converted into a format (such as a byte stream) that can be saved to a file or sent over a network and later restored to its original state i.e. as an object in java program.

 */
import java.io.*;


public class JavaBeans {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        // Serialization: Saving the object to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);  // Convert person object to a byte stream
            System.out.println("beans.Person object serialized and saved to person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization: Reading the object from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) in.readObject();  // Convert byte stream back to a beans.Person object
            System.out.println("Deserialized beans.Person: " + deserializedPerson.getName() + ", Age: " + deserializedPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



class Person implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


}

