/*
1. We cannot have a private class. There can be sub privateClasses within the parent class which can be private.

2. All the private properties and methods inside the sub class can be accessed by the parent class itself
 */
package privateClasses;

public class privateClassExample {

    public ChildClass c;

    public privateClassExample(){
        this.c=new ChildClass(5);
        System.out.println(this.c.x);
    }

    private class ChildClass{
        private int x;
        public ChildClass(int x){
            this.x=x;
        }
    }
}
