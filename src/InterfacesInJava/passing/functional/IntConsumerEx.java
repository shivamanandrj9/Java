package InterfacesInJava.passing.functional;

/*
IntConsumer ek already functional interface hai, jisme ek method hota hai accept and since ye consumer hai to bas value leta hai but return nahi karta hai.

isko bhi ab previous example ki tarah use karenge, its just that previous example me humne khud se functional interface define kara tha
 */

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class IntConsumerEx {

    public static void main(String[] args) {
        IntConsumer receipe=(n)->{
            System.out.println(n);
        };

        useIt(receipe);
    }

    static void useIt(IntConsumer x){
        x.accept(10);
    }

}


