package 精选一百道题.动态规划类.分割等和子集;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 5};
        System.out.println(solution.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        boolean[] vis = new boolean[nums.length];
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        return fun(nums, target, 0, dp) == 1;
    }

    private int fun(int[] nums, int target, int temp, int[][] dp) {
        if (temp == nums.length) {
            return target == 0 ? 1 : -1;
        }
        if (dp[temp][target] != 0) {
            return dp[temp][target];
        }
        if (target - nums[temp] >= 0) {
            dp[temp][target] = Math.max(fun(nums, target - nums[temp], temp + 1, dp), fun(nums, target, temp + 1, dp));
        } else {
            dp[temp][target] = fun(nums, target, temp + 1, dp);
        }
        return dp[temp][target];
    }
}