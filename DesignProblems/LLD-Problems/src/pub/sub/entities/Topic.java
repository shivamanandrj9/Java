package pub.sub.entities;

public class Topic {

    int id;
    String name;
    int capacity;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Topic(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

}
