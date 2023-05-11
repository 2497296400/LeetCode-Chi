package 手写一系列东西.一些列小测试;

import lombok.Data;
import sun.misc.Unsafe;

public class UnsafeTest {
    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        A b = new A();
        System.out.println(b.getB());
        A a = (A) unsafe.allocateInstance(A.class);
        System.out.println(a.getB());
    }
}

@Data
class A {
    private int b;

    public A() {
        this.b = 1;
    }
}