package pub.sub.entities;

public class Subscriber {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public Subscriber(String name) {
        this.name = name;
    }

    String name;
}
