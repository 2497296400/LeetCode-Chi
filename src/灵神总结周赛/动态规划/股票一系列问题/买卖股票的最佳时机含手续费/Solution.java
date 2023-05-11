package 灵神总结周赛.动态规划.股票一系列问题.买卖股票的最佳时机含手续费;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        Integer[][] dp = new Integer[prices.length][2];
        return fun(prices, 0, false, dp, fee);
    }

    private int fun(int[] prices, int index, boolean hold, Integer[][] dp, int fee) {
        if (index == prices.length) {
            return 0;
        }
        int status = hold ? 1 : 0;
        if (dp[index][status] != null) {
            return dp[index][status];
        }
        int a, b = 0, c = 0;
        a = fun(prices, index + 1, hold, dp, fee);
        if (hold) {
            b = fun(prices, index + 2, false, dp, fee) + prices[index];
        }
        if (!hold) {
            c = fun(prices, index + 1, true, dp, fee) - prices[index] - fee;
        }
        return dp[index][status] = Math.max(a, Math.max(b, c));
    }
}

