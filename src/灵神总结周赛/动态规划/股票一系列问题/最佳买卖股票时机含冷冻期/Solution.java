package 灵神总结周赛.动态规划.股票一系列问题.最佳买卖股票时机含冷冻期;

public class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return fun(prices, 0, false, dp);
    }

    private int fun(int[] prices, int index, boolean hold, Integer[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        int status = hold ? 1 : 0;
        if (dp[index][status] != null) {
            return dp[index][status];
        }
        int a, b = 0, c = 0;
        a = fun(prices, index + 1, hold, dp);
        if (hold) {
            b = fun(prices, index + 2, false, dp) + prices[index];
        }
        if (!hold) {
            c = fun(prices, index + 1, true, dp) - prices[index];
        }
        return dp[index][status] = Math.max(a, Math.max(b, c));
    }
}
