//This is helpful when there are multiple types of students. Then on line 14 we put if condition on which builder (student1 builder or student2 builder) to be injected at line 5. Then we have 2 construct thing. 1) constructStudent1 2)constructStudent2 and then it does the same thing that it is doing now.
//If we have only one student then we can omit this director as this is bit of an overkill.






package creational.builder;

public class StudentDirector_Optional {
    private final StudentBuilder builder;
    public StudentDirector_Optional(StudentBuilder b) {
        this.builder = b;
    }
    public Student constructFullStudent(int age, String grade, String address) {
        return builder
                .age(age)
                .grade(grade)
                .address(address)
                .build();
    }
}

