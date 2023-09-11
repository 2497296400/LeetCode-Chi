package 左神算法集.约瑟夫环问题;

public class Solution {
    public static int getLive(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return ((getLive(n - 1, m) + m - 1) % n) + 1;
    }

    public static void main(String[] args) {
        int n = 10, m = 1;
        int last = 0;
        for (int i = 1; i <= n; i++) {
            last = (last + m) % i;
        }
        System.out.println(last + 1);
        System.out.println(getLive(n, m));
    }
}
