package BuilderDesignPattern;

public class CarBuilder {

    private int id;
    private String name;
    private int doorCount;
    private int capacity;

    public CarBuilder id(int id)
    {
        this.id=id;
        return this;
    }

    public CarBuilder name(String name)
    {
        this.name=name;
        return this;
    }

    public CarBuilder doorCount(int doorCount){
        this.doorCount=doorCount;
        return this;
    }

    public CarBuilder capacity(int capacity){
        this.capacity=capacity;
        return this;
    }

    public Car build(){
        return new Car(name,id,doorCount,capacity);
    }
}
