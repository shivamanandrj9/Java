package oops;

public class Method_overloading {
    public static void main(String[] args) {
        System.out.println(dosum(1,2));
        System.out.println(dosum(1,2,3));
    }

    static int dosum(int a,int b,int c)
    {
        System.out.println("3 val");
        return a+b+c;
    }

    static int dosum(int a,int b){
        System.out.println("2 val");
        return a+b;
    }
}
