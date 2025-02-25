package Annotations.MethodAnnotationExample;

import Annotations.ClassAnnotationExample.AnnotatedClassWithImportatntClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassConsumingTheAnnotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        AnnotatedMethodWithRunImmediately annotatedClassWithImportatntClass = new AnnotatedMethodWithRunImmediately("Shivam");

        for(Method method: annotatedClassWithImportatntClass.getClass().getMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){

                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for(int i=0;i< annotation.times();i++)
                    method.invoke(annotatedClassWithImportatntClass);
            }
        }
    }
}
