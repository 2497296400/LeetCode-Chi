package 灵神总结周赛.动态规划.恰好移动k步到达某一位置的方法数目;

import java.util.Arrays;

public class Solution {
    int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfWays(272, 270, 6));
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[k][2000];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(startPos + 1000, endPos + 1000, k, dp);
    }

    private int fun(int startPos, int endPos, int k, int[][] dp) {
        if (k == 0) {
            if (startPos == endPos) {
                return 1;
            }
            return 0;
        }
        if (Math.abs(endPos - startPos) > k) {
            return 0;
        }
        if (dp[k][startPos] != -1) {
            return dp[k][startPos];
        }
        int ans = (fun(startPos + 1, endPos, k - 1, dp) % MOD + fun(startPos - 1, endPos, k - 1, dp) % MOD) % MOD;
        return dp[k][startPos] = ans % MOD;
    }
}
