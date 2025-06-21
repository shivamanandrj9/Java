package creational.prototype;

public interface Prototype {
    // Any class implementing this can be assigned to prototype interface. That why the return type Prototype works.
    public Prototype clone();
}
