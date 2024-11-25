
//If I want to pass the current object of UsingThis to another method that might be using its properties. We can directly do it by passing this methodCall(this).

//this() can also be used, this will call the constrtuctor of the current class. class(a)-> This will call the parametrized constructor
class UsingThis{

    private int a=5;

    UsingThis(int a){
        this.a=a;
    }

    public int getA(){
        return this.a;
    }

}


public class ThisKeyword {
    public static void main(String[] args) {
        UsingThis usingThis=new UsingThis(6);
        System.out.println(usingThis.getA());
    }
}
