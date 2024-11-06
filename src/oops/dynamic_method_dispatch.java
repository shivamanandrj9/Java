package oops;


/*

Class Parent -> Class Child

It is allowed to create a reference of Parent class but point it to the object of the child class.
Now all the methods that are in the Parent class will run but if that method has been overridden in that child class,
the overriden will run.

 */

class Phone{
    public void start(){
        System.out.println("The phone has started");
    }

    public void stop(){
        System.out.println("The phone has stopped");
    }
}

class SmartPhone extends Phone{
    @Override
    public void start() {
        System.out.println("The smartphone has started");

    }

    public void playMusic(){
        System.out.println("Started playing music");
    }

}

public class dynamic_method_dispatch {
    public static void main(String[] args) {

        //a is the reference which is pointing to an object of type Smartphone
        Phone a= new SmartPhone();

        a.start();
        a.stop();

        //a.playMusic();  <- this will give error

    }
}
