package InterfacesInJava.passing.functional;

import java.util.function.Consumer;

public class ConsumerFunctionalInterfcae {

    public static void main(String[] args) {
        Consumer<Integer> receipe=(x)->{
            System.out.println(2*x);
        };

        useId(receipe);
    }

    static void useId(Consumer<Integer> hue){
        hue.accept(10);
    }
}
