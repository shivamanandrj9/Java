package oops;
//this just only tells ki T1 and T2 are some data types that we are not sure about r8 now.

class MyGeneric<T1,T2>{
    public T1 a;
    public T2 b;

    MyGeneric(T1 aa, T2 bb){
        a=aa;
        b=bb;
    }

}



public class generics {
    public static void main(String[] args) {

        //for oops.generics we can't use primitive data types
        MyGeneric<Integer,String> mygeneric=new MyGeneric<Integer, String>(4,"ramesh");
        System.out.println(mygeneric.a);
        System.out.println(mygeneric.b);
    }
}
