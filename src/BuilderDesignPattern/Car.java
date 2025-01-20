package BuilderDesignPattern;

public class Car {

    private int id;
    private String name;
    private int doorCount;
    private int capacity;

    Car(String name, int id, int doorCount, int capacity) {
        this.name = name;
        this.id = id;
        this.doorCount = doorCount;
        this.capacity = capacity;
    }

    public String toString(){
        return "Name: "+name+" Id: "+id+" DoorCount: "+doorCount+" Capacity: "+capacity;
    }
}
