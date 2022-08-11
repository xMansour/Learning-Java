import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationBasics {
    String str() default "Annotations Basics";
    int val() default 1;
}
