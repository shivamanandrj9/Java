package Annotations.MethodAnnotationExample;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {

    int times() default 1;

}
