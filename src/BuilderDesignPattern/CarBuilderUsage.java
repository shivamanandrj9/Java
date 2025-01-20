package BuilderDesignPattern;

public class CarBuilderUsage {
    public static void main(String[] args) {

        Car x=new CarBuilder().id(5).name("Shivam").build();


        System.out.println(x);
    }
}
