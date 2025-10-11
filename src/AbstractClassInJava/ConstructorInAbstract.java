/*
For an abstract class also, there is the same flow of constructor that happens.
All abstract class have a default no arg constructor which is called by any extended class's constructor(See the ConstructorFlow package) like it happens when we extend any concrete class.
 */

package AbstractClassInJava;

class AbstractClass {
    private int value;
    public int pubval;
    /*
    Since there is no no-arg constructor, the extending concrete class's constructor must call this constructor via super.
     */
    AbstractClass(int value){
        this.value=value;
    }
}

public class ConstructorInAbstract extends AbstractClass{
    ConstructorInAbstract(){
        super(5);
    }

    public static void main(String[] args) {
        ConstructorInAbstract constructorInAbstract=new ConstructorInAbstract();
        constructorInAbstract.pubval=10;
        System.out.println(constructorInAbstract.pubval);
    }
}
