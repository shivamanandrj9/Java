package variablePassing;

public class PrimitivePassing {
    public static void main(String[] args) {
        int hello=5;
        increment(hello);
        System.out.println(hello);
    }

    private static void increment(int val){
        val++;
    }
}
