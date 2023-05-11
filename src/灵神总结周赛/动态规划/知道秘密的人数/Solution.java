package 灵神总结周赛.动态规划.知道秘密的人数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.peopleAwareOfSecret(4, 1, 3));
    }

    int MOD = (int) (1e9 + 7);

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        //dp[0] = 1;
  /*      for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            int deep = 0;
            if (i >= forget) {
                deep = (int) dp[i - forget];
                dp[i] -= dp[i - forget];
                for (int j = i - 1; j >= i - forget; j--) {
                    dp[j] -= deep;
                }
            }
            if (i >= delay) {
                dp[i] += dp[i - delay] % MOD;
            }
        }*/
        return fun(n, delay, forget, 1, dp);
        //return (int) (dp[n - 1] % MOD);
    }

    private int fun(int n, int delay, int forget, int cur, long[] dp) {
        if (cur + delay > n) {
            return 1;
        }
        if(dp[cur]!=-1){
            return (int) dp[cur];
        }
        //如果由当前状态推下一个状态 需要当前状态复制
        long res = cur + forget <= n ? 0 : 1;
        for (int i = cur + delay; i <= Math.min(cur + forget - 1, n); i++) {
            res += fun(n, delay, forget, i, dp)%MOD;
        }
        return (int) (dp[cur]= res%MOD);
    }
}
