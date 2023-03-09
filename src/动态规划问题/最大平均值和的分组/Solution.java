package 动态规划问题.最大平均值和的分组;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9, 1, 2, 3, 9};
        System.out.println(solution.largestSumOfAverages(arr, 3));
    }

    public double largestSumOfAverages(int[] nums, int k) {
        double[] preSum = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        Double[][] dp = new Double[k+1][nums.length + 1];
        return fun(nums, k, 0, preSum,dp);
    }

    private double fun(int[] nums, int k, int curIndex, double[] preSum, Double[][] dp) {
        if(dp[k][curIndex]!=null){
            return  dp[k][curIndex];
        }
        if (curIndex == nums.length) {
            return 0;
        }
        if (k == 1) {
            return (preSum[nums.length] - preSum[curIndex]) / (nums.length - curIndex);
        }
        double ans = 0;
        for (int l = curIndex; l < nums.length; l++) {
            ans = Math.max(ans, fun(nums, k - 1, l + 1, preSum, dp) + (preSum[l + 1] - preSum[curIndex]) / (l - curIndex + 1));
        }
        dp[k][curIndex]=ans;
        return ans;
    }
}
