package InterfacesInJava;

public class IntefaceUsage {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.sayHi();

    }
}


class MyClass implements BasicInterface{
    public void sayHello(){
        System.out.println("Hello");
    }

    public void sayHi(){
        System.out.println("Hi");
    }
}