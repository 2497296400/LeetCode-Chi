package 每日一题系列.每日一题八月.阶乘后的零;

public class Solution {
    public static void main(String[] args) {
        int n=100;
        long sum=1;
        for(int i=1;i<=n;i++){
            sum*=i;
            System.out.println(sum+" 当前"+i);
        }
    }
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
