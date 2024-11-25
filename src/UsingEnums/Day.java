package UsingEnums;


//This is just a class which basically extends another special class in backend for enum features;
public enum Day {

    //these are all instances of Day class
    MONDAY("Somwar"), TUESDAY("Mangalwar"), WEDNESDAY("Budh"), THURSDAY("Brihaspat"), FRIDAY("Sukra"), SATURDAY("Sani"), SUNDAY("Aitwar");


    //defining a custom property
    public String hindiName;


    //defining a custom construtor
    //these are private by default
    private Day(String s){
        this.hindiName=s;
    }

    //similarly, we can create any method which can be used with any class

}
