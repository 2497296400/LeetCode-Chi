package 灵神总结周赛.动态规划.完美分割的方案数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.beautifulPartitions("23542185131", 3, 2));
    }

    int MOD = (int) (1e9 + 7);

    public int beautifulPartitions(String s, int k, int minLength) {
        int[][] dp = new int[s.length()][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        char[] chars = s.toCharArray();
        return fun(chars, 0, k, minLength, dp);

    }

    private int fun(char[] chars, int index, int k, int minLength, int[][] dp) {
        if (k == 0) {
            return index == chars.length ? 1 : 0;
        }
        if (index == chars.length) {
            return k == 0 ? 1 : 0;
        }
        long ans = 0;
        if (dp[index][k] != -1) {
            return dp[index][k];
        }
        for (int i = index; i + minLength * k <= chars.length; i++) {
            int f = chars[index] - '0';
            int s = chars[i + minLength - 1] - '0';
            if (isPrime(f) && !isPrime(s)) {
                // System.out.println(f + " " + s);
                ans += fun(chars, i + minLength, k - 1, minLength, dp) % MOD;
            }
        }
        return dp[index][k] = (int) (ans % MOD);
    }

    public boolean isPrime(int cur) {
        if (cur == 2 || cur == 3 || cur == 5 || cur == 7) {
            return true;
        }
        return false;
    }
}
