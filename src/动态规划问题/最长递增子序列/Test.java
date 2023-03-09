package 动态规划问题.最长递增子序列;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        test.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return fun(nums, -1, 0, dp);
    }

    private int fun(int[] nums, int pre, int index, int[] dp) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans = 0;
        for (int i = index; i < nums.length; i++) {
            if (pre == -1 || nums[i] > nums[pre]) {
                ans = Math.max(ans, fun(nums, i, i + 1, dp) + 1);
            }
        }
        dp[index] = ans;
        return ans;
    }
}
