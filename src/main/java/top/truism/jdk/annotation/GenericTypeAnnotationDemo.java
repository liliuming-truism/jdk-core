package top.truism.arthasproject.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.util.List;

public class GenericTypeAnnotationDemo {

    public void processList(@NonEmpty List<String> strings) {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 通过反射获取方法参数的注解信息
        AnnotatedType[] annotatedParameterTypes = GenericTypeAnnotationDemo.class
            .getMethod("processList", List.class)
            .getAnnotatedParameterTypes();

        AnnotatedType annotatedParameterType = annotatedParameterTypes[0];
        Annotation[] annotations = annotatedParameterType.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof NonEmpty) {
                System.out.println("Parameter has @NonEmpty annotation");
            }
        }
    }

    @Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NonEmpty {

    }

}
