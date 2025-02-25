package Annotations.FieldAnnotationExample;

import Annotations.ClassAnnotationExample.ImportantClass;
import Annotations.MethodAnnotationExample.RunImmediately;

public class ClassWithFieldAnnotated {

    @ImportantField
    public String name;

    public ClassWithFieldAnnotated(String name){
        this.name=name;
    }


}
