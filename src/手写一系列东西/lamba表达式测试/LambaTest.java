package 手写一系列东西.lamba表达式测试;

import java.util.stream.Stream;

public class LambaTest {
    public static void main(String[] args) {
        GetSum getSum = (a, b) -> a * b;
        System.out.println(getSum.getSum(1, 2));
        System.out.println(test(1, 2, (a, b) -> a * b));
        Stream.of(1, 2, 3, 4, 5)
                .filter(a -> a > 2)
                .forEach(System.out::println);
        
    }

    public static int test(int f, int s, GetSum getSum) {
        return getSum.getSum(f, s) + f + s;
    }
}
