package Annotations.ClassAnnotationExample;


import java.lang.annotation.*;

@Target(ElementType.TYPE) //This gives info about the things above which annotations can be used, ElementType.Type -> Class, ElementType.METHOD -> Method. We can even pass multiple of these by using {} like {ElementType.TYPE, ElementType.METHOD}.
@Retention(RetentionPolicy.RUNTIME) //This give info that till what time this annotations will be available to be used. RetentionPolicy.CLASS -> till the class is compiled, RetentionPolicy.RUNTIME -> till the program is running, RetentionPolicy.SOURCE -> till the source code is there.
public @interface ImportantClass {
}
