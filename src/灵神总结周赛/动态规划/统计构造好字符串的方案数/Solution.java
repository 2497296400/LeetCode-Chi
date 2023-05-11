package 灵神总结周赛.动态规划.统计构造好字符串的方案数;

import java.util.Arrays;

public class Solution {
    int MOD = (int) (1e9 + 7);
    int curAns = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodStrings2(2, 3, 1, 2));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[0] = 1;
        
        for (int i = 0; i <= high; i++) {
            if (i >= one) {
                dp[i] = dp[i] + dp[i - one] % MOD;
            }
            if (i >= zero) {
                dp[i] = dp[i] + dp[i - zero] % MOD;
            }
        }
        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dp[i];
            ans %= MOD;
        }
        return (int) ans;
    }

    public int countGoodStrings2(int low, int high, int zero, int one) {
        long asn = 0;
        long[] dp = new long[high+1];
        Arrays.fill(dp, -1);
        for (int i = low; i <= high; i++) {
            asn += fun(i, zero, one, dp) % MOD;
        }
        return (int) asn;
        
    }

    private long fun(int i, int zero, int one, long[] dp) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        long ans = 0;
        ans += fun(i - zero, zero, one, dp)%MOD + fun(i - one, zero, one, dp)%MOD;
        return dp[i] = ans%MOD;
    }
}
