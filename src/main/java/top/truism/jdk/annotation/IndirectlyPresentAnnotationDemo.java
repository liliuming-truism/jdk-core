package top.truism.arthasproject.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解间接存在
 *
 */
@IndirectlyPresentAnnotationDemo.RepetableAnnotations(value = {
    @IndirectlyPresentAnnotationDemo.RepetableAnnotation("1"),
    @IndirectlyPresentAnnotationDemo.RepetableAnnotation("2")
})
public class IndirectlyPresentAnnotationDemo {

    public static void main(String[] args) {

        Annotation[] annotations = IndirectlyPresentAnnotationDemo.class.getDeclaredAnnotationsByType(RepetableAnnotation.class);
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface RepetableAnnotations {

        RepetableAnnotation[] value();

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(RepetableAnnotations.class)
    public @interface RepetableAnnotation {
        String value() default "defaultValue";
    }

}
