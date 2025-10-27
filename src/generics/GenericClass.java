package generics;

public class GenericClass<A,B,C> {
    A var1;
    B var2;
    C var3;

    A getVar1(){
        return this.var1;
    }

    B getVar2(){
        return this.var2;
    }

    C getVar3(){
        return this.var3;
    }
}
