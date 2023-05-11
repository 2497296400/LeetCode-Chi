package 灵神总结周赛.动态规划.股票一系列问题.股票平滑下跌阶段的数目;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getDescentPeriods(new int[]{3, 2, 1, 4}));
    }

    public long getDescentPeriods(int[] prices) {
        long ans = prices.length;
        int l = 0, r = 1;
        while (r < prices.length) {
            int target = prices[l];
            while (r < prices.length && target - prices[r] == 1) {
                target = prices[r];
                ans += r - l;
                r++;
            }
            l = r;
            r++;
        }
        return ans;
    }
}
