package 灵神总结周赛.动态规划.股票一系列问题.买卖股票的最佳时机III;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][3];
        return fun(prices, 0, false, dp, 2);
    }

    private int fun(int[] prices, int index, boolean hold, Integer[][][] dp, int limit) {
        if (index == prices.length) {
            return 0;
        }
        int status = hold ? 1 : 0;
        if (dp[index][status][limit] != null) {
            return dp[index][status][limit];
        }
        int a, b = 0, c = 0;
        a = fun(prices, index + 1, hold, dp, limit);
        if (hold && limit > 0) {
            b = fun(prices, index + 1, false, dp, limit - 1) + prices[index];
        }
        if (!hold && limit > 0) {
            c = fun(prices, index + 1, true, dp, limit) - prices[index];
        }
        return dp[index][status][limit] = Math.max(a, Math.max(b, c));
    }
}
