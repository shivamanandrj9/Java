package GO4.creational.prototype;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Shivam",23);
        Person copy = person.clone();
        System.out.println(copy.getName());
    }
}
