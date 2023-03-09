package 每日一题系列.每日一题二月.掷骰子模拟;

public class Solution {
    int MOD = (int) (1e9 + 7);
    int N;

    public int dieSimulator(int n, int[] rollMax) {
        N = n;
        Integer[][][] dp = new Integer[n][7][16];
        return dfs(0, 0, rollMax, dp, 0);
    }

    private int dfs(int curIndex, int preIndex, int[] rollMax, Integer[][][] dp, int curTimes) {
        if (curIndex >= dp.length) {
            return 1;
        }
        if (dp[curIndex][preIndex][curTimes] != null) {
            return dp[curIndex][preIndex][curTimes];
        }
        long ans = 0L;
        for (int cur = 1; cur <= 6; cur++) {
            if (preIndex != cur) {
                ans += dfs(curIndex + 1, cur, rollMax, dp, 1);
            } else if (curTimes + 1 <= rollMax[cur - 1]) {
                ans += dfs(curIndex + 1, cur, rollMax, dp, curTimes + 1);
            }
        }
        ans = (ans + MOD) % MOD;
        dp[curIndex][preIndex][curTimes] = (int )ans;
        return(int ) ans;
    }
}

