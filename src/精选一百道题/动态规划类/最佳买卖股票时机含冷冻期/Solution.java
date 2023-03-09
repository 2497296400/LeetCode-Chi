package 精选一百道题.动态规划类.最佳买卖股票时机含冷冻期;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 0, 2};
        System.out.println(solution.maxProfit(nums));
        System.out.println( solution.toFun(nums));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }

        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));

    }

    private int fun(int[] prices, int start, int[] dp) {
        if (start >= prices.length) {
            return 0;
        }
        if (dp[start] != 0) {
            return dp[start];
        }

        int cur = 0;

        for (int i = start + 1; i < prices.length; i++) {
            cur = Math.max(cur, Math.max(fun(prices, i + 2, dp) + prices[i] - prices[start], fun(prices, i,
                    dp)));
            dp[start] = cur;
        }
        return dp[start];
    }
    public  int   toFun(int []prise){
        int []dp=new int[prise.length];
        for(int i=0;i<prise.length;i++){
            int cur=0;
            for(int j=i+1;j<prise.length;j++){
                if(j+2<prise.length){
                cur=Math.max(cur,Math.max(dp[j+2]+prise[j]-prise[i],dp[j]));
                dp[i]=cur;
             }
            }
        }
        return dp[prise.length-1];
    }
}
