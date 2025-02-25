package Annotations.FieldAnnotationExample;

import java.lang.reflect.Field;

public class ClassConsumingTheAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        ClassWithFieldAnnotated classWithFieldAnnotated = new ClassWithFieldAnnotated("Shivam");

        for(Field field: classWithFieldAnnotated.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantField.class)){
                Object object = field.get(classWithFieldAnnotated);
                if(object instanceof String stringVal){
                    System.out.println(stringVal);
                }
            }
        }
    }
}
