package top.truism.arthasproject.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PresentAnnotationDemo extends SuperClass implements SuperInterface{

    public static void main(String[] args) {

        Annotation[] annotations = PresentAnnotationDemo.class.getAnnotations();
        for (Annotation annotation : annotations) {
            // SuperClassAnnotation("superClass")
            System.out.println(annotation);
        }
        Annotation annotation = PresentAnnotationDemo.class.getAnnotation(SuperClassAnnotation.class);
        // SuperClassAnnotation("superClass")
        System.out.println(annotation);

        Annotation interfaceAnnotation = PresentAnnotationDemo.class.getAnnotation(SuperInterfaceAnnotation.class);
        // null
        System.out.println(interfaceAnnotation);
    }

    /**
     * @Inherited 表示注解可被继承，注意，只有在类上使用才会被继承，在接口、方法、成员变量上使用不会被继承
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface SuperClassAnnotation {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface SuperInterfaceAnnotation {
        String value();
    }

}

@PresentAnnotationDemo.SuperClassAnnotation("superClass")
class SuperClass {

}

@PresentAnnotationDemo.SuperInterfaceAnnotation("superInterface")
interface SuperInterface {

}