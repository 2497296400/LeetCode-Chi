package 精选一百道题.动态规划类.买股票的最佳时机;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        if (prices.length <= 1) {
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}
