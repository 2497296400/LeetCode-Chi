package 手写一系列东西.lamba表达式测试;

public class LambaTest {
    public static void main(String[] args) {
        GetSum getSum = Integer::sum;
        System.out.println(getSum.getSum(1, 2));
        System.out.println(test(1, 2, (a,b)->a*b));
    }

    public static int test(int f, int s, GetSum getSum) {
        return getSum.getSum(f, s)+f + s;
    }
}
