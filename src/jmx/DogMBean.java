package jmx;

public interface DogMBean {
    public int getAge();
    public void setAge(int newAge);
    public String getName();
    public void setName(String newName);
    public void bark();
}
