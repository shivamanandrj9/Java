package variablePassing;

public class NonPrimitivePassing {

    public static void main(String[] args) {
        Integer hello=5;
        increment(hello);
        System.out.println(hello);
    }

    private static void increment(Integer val){
        val++;
    }
}
