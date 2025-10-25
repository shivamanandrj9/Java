package GO4.creational.builder;


public class StudentBuilder {

    //Required
    public String firstName;
    public String lastName;

    //Optional
    public Integer age    = null;
    public String grade   = null;
    public String address = null;

    public StudentBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public StudentBuilder age(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder grade(String grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}

