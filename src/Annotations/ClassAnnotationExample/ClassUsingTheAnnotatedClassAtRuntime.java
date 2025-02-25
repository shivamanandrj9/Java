package Annotations.ClassAnnotationExample;

public class ClassUsingTheAnnotatedClassAtRuntime {

    public static void main(String[] args) {

        AnnotatedClassWithImportatntClass annotatedClassWithImportatntClass = new AnnotatedClassWithImportatntClass("Shivam");
        if(annotatedClassWithImportatntClass.getClass().isAnnotationPresent(ImportantClass.class))
        {
            System.out.println("Apply any logic if you want");
        }
    }
}
