public class SingletonEnum {
    public static void main(String[] args) {
        singletonEnum.INSTANCE.sayHi();
    }

}


enum singletonEnum{
    INSTANCE;

    private singletonEnum(){

    }

    public void sayHi(){
        System.out.println("Say Hi");
    }
}
