package UsingEnums;

public class MyClass {
    public static void main(String[] args) {

        //Day.MONDAY returns an object of class Day. its to_string() method is being called while doing sout.
        System.out.println(Day.MONDAY);


        Day day=Day.TUESDAY;
        //there are multiple methods we get of the classes.
        System.out.println(day.ordinal());


        System.out.println(day.hindiName);
        System.out.println(Day.FRIDAY.hindiName);

    }
}
