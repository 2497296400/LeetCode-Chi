package 每日一题系列.每日一题九月.求出最长好子序列I;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {48,49,49,48,48};
        System.out.println(solution.maximumLength(nums, 2));
    }

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ans = 0;
        for (int i = 0; i < nums.length ; i++) {
            ans = Math.max(ans, fun(nums, k, -1, i , dp));
        }
        return ans;
    }

    private int fun(int[] nums, int k, int preIndex, int index, int[][] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[preIndex][index] != -1) {
            return dp[preIndex][index];
        }
        int ans = 0;
        if (nums[preIndex] == nums[index]) {
            ans = Math.max(ans, 1 + fun(nums, k, index, index + 1, dp));
        } else {
            if (k > 0) {
                ans = Math.max(ans, 1 + fun(nums, k - 1, index, index + 1, dp));
            }
            ans = Math.max(ans, fun(nums, k, preIndex, index + 1, dp));
            dp[preIndex][index] = ans;
        }
        return ans;
    }
}
