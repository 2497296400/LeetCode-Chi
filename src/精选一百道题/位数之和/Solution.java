package 精选一百道题.位数之和;

public class Solution {
    public int countEven(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (tosum(i) % 2 == 0) {
                sum++;

            }
        }
        return sum;
    }
    private int tosum(int i) {
        int temp = 0;
        for (; i != 0; ) {
            temp += i % 10;
            i = i / 10;
        }
        return temp;
    }
}
