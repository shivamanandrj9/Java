package creational.singleton.Eager;

public class SingletonUsage {
    public static void main(String[] args) {
        SingletonClass singletonClass=SingletonClass.getInstance();
        System.out.println(singletonClass.getVal());
    }
}
