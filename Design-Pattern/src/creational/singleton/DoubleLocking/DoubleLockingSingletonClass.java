package creational.singleton.DoubleLocking;

public class DoubleLockingSingletonClass {

    private static DoubleLockingSingletonClass INSTANCE;

    private DoubleLockingSingletonClass(){}

    public static DoubleLockingSingletonClass getInstance(){

        if(INSTANCE == null){

            synchronized (DoubleLockingSingletonClass.class){

                if(INSTANCE == null){
                    INSTANCE = new DoubleLockingSingletonClass();
                }
            }
        }
        return INSTANCE;
    }
}


// Every class is converted to "class object" when JVM compiles the classes.
// We can get that object Class<?> clazzLiteral = DoubleLockingSingletonClass.class or Class<?> clazzReflect = Class.forName("creational.singleton.DoubleLocking.DoubleLockingSingletonClass");
//This class object have built in lock that we can use whenever required. Hence we used this lock instead of creating our own.