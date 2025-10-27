package generics;

public class GenericMethod {

    public static void main(String[] args) {
        System.out.println(method(10));
    }

    private static <T> T method(T input2){
        return input2;
    }
}
