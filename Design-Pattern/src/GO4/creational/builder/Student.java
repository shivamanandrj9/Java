package GO4.creational.builder;

public class Student {
    // required
    private final String firstName;
    private final String lastName;
    // optional
    private final Integer age;
    private final String grade;
    private final String address;

    public Student(StudentBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName  = builder.lastName;
        this.age       = builder.age;
        this.grade     = builder.grade;
        this.address   = builder.address;
    }

    // getters...
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    public Integer getAge()      { return age;       }
    public String getGrade()     { return grade;     }
    public String getAddress()   { return address;   }
}

