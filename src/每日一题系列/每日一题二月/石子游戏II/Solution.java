package 每日一题系列.每日一题二月.石子游戏II;

public class Solution {
    int[] preSum;

    public int stoneGameII(int[] piles) {
        preSum = new int[piles.length + 1];
        for (int i = 1; i <= piles.length; i++) {
            preSum[i] += preSum[i - 1] + piles[i - 1];
        }
        Integer[][][] dp = new Integer[piles.length][piles.length][2];
        return getAli(1, 0, piles, 0, dp);
    }

    private int getAli(int M, int curIndex, int[] piles, int status, Integer[][][] dp) {
        if (curIndex == piles.length) {
            return 0;
        }
        int max;
        max = status == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        if (dp[curIndex][M][status] != null) {
            return dp[curIndex][M][status];
        }
        for (int i = curIndex; i < curIndex + 2 * M && i < piles.length; i++) {
            int curSum = preSum[i + 1] - preSum[curIndex];
            int m = Math.max(M, i - curIndex + 1);
            if (status == 0) {
                int nextMax = getAli(m, i + 1, piles, 1, dp);
                max = Math.max(max, nextMax + curSum);
            } else {
                int nextMin = getAli(m, i + 1, piles, 0, dp);
                max = Math.min(max, nextMin);
            }
        }
        dp[curIndex][M][status] = max;
        return max;
    }
}
