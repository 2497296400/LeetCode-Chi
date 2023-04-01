package 测试代码;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        String a = "aaa";
        Class<? extends String> aClass = a.getClass();
        Field age = aClass.getDeclaredField("value");
        age.setAccessible(true);
        age.set(a, "sadd".toCharArray());
        System.out.println(a);
    }
}
