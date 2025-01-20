public class SingletonClass {
    public static void main(String[] args) {

        //this also works
        MySingletonClass mx=MySingletonClass.getInstance();
    }
}

class MySingletonClass{

    private static MySingletonClass myClass = new MySingletonClass();

    private MySingletonClass(){

    }

    //if we don't write this then myClass need to be public static. But we do this add an additional step for safety access.
    public static MySingletonClass getInstance(){
        return myClass;
    }
}
