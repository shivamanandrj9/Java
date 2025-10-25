package GO4.creational.prototype;

public class Person implements Prototype{

    private String name;
    private int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public Person clone(){
        Person cpy=new Person(this.name,this.age);
        return cpy;
    }
}
