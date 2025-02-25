package Annotations.MethodAnnotationExample;

import jmx.SimpleMBeanServer;

public class AnnotatedMethodWithRunImmediately {
    private String name;

    public AnnotatedMethodWithRunImmediately(String name){
        this.name=name;
    }

    @RunImmediately(times = 5)
    public void method1(){
        System.out.println("Method 1 called");
    }

    @RunImmediately
    public void method2(){
        System.out.println("Method 2 called");
    }
}
