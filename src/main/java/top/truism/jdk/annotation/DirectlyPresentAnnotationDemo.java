package top.truism.arthasproject.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@DirectlyPresentAnnotationDemo.DirectPresentAnnotation
public class DirectlyPresentAnnotationDemo {

    public static void main(String[] args) {
        Annotation[] annotations = DirectlyPresentAnnotationDemo.class.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Annotation annotation = DirectlyPresentAnnotationDemo.class.getDeclaredAnnotation(DirectPresentAnnotation.class);
        System.out.println(annotation);
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface DirectPresentAnnotation {
        String value() default "defaultValue";
    }
}
