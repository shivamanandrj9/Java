package oops;

public class Example1 {
    public static void main(String[] args) {
        ChildClass c=new ChildClass();
        c.setProperty1(10);
        System.out.println(c.getProperty());
    }
}

class ParentClass{
    private int property1;

    void setProperty1(int val){
        this.property1=val;
    }

    int getProperty(){
        return this.property1;
    }
}

class ChildClass extends ParentClass{

}