package Top集合.买卖股票的最佳时机II;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int set;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                ans += prices[i] - buy;
                    buy = prices[i];
                }
            else {
                buy = prices[i];
            }
        }
        return ans;
    }
}