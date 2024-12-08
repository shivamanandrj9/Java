public class AbstractMethodAndClass {
    public static void main(String[] args) {
        child x=new child();
        x.sayHello();
    }
}

//cannot create object of it until we define the sayHello method.
abstract class parent{
    private int x;

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x=x;
    }

    public abstract void sayHello();
}

class child extends parent{
    public void sayHello(){
        System.out.println("Hello");
    }
}
