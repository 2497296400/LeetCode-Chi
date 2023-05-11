package 手写一系列东西.一些列小测试;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestInheritedAnnotation {
    String[] value()default "1";
    int number()default 2;
}

