//Annotations are used to provide metadata to the compiler. It does not affect the execution of the program.
//through annotations we are providing some extra infromation to the compiler and to the runtime
//They are typically used to provide instructions to tools, libraries, or the compiler.

public class Annotations {
    public void show(){
        System.out.println("Hello from Annotations");
    }
}

class ExtendedAnnotations extends Annotations {

    @Override
    public void show(){
        System.out.println("Hello from Annotations");
    }
}


