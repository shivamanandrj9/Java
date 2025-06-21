package creational.builder;

public class Main_withDirector {
    public static void main(String[] args) {
        StudentBuilder b = new StudentBuilder("Alice", "Smith");
        StudentDirector_Optional director = new StudentDirector_Optional(b);
        Student s = director.constructFullStudent(21, "A", "123 Maple St.");

    }
}
