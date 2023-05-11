package 手写一系列东西.一些列小测试;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class 泛型测试 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List[] lsa = new List[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(new Integer(3));
        oa[1] = li;
        Object o1 = lsa[1].get(0);
        //li.getClass().getMethod("add", Object.class).invoke(li, "asd");
        Type superclass = li.getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        System.out.println(type);
        String o2 = (String) lsa[1].get(1);
        System.out.println(o2);
        System.out.println((Integer) o1);
    }
}
