package 手写一系列东西.一些列小测试;

import java.lang.annotation.Annotation;

public class 注解测试 {
    @TestInheritedAnnotation(value = "2", number = 9)
    class person {
    }

    class student extends person {
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Class<student> aClass = student.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            TestInheritedAnnotation t = (TestInheritedAnnotation) annotation;
            System.out.println(t.value()[0]  + " "+ t.number());
        }
    }
}
