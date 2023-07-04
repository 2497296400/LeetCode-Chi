package 动态规划问题.最长递增子序列;

import java.util.Arrays;

public class DFSTest {
    public static void main(String[] args) {
        DFSTest dfsTest = new DFSTest();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(dfsTest.longestIncreasingSubsequence(nums));

    }

    public int longestIncreasingSubsequence(int[] nums) {
        int ans = 1;
        int[][] dp = new int[nums.length][nums.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(nums, i, -1, dp));
        }
        return ans;
    }

    private int dfs(int[] nums, int index, int pre, int[][] dp) {
        if (index < 0) {
            return 0;
        }
        int ans = 0;
        if (pre != -1 && dp[index][pre] != -1) {
            return dp[index][pre];
        }
        if (pre == -1 || nums[index] < nums[pre]) {
            ans = Math.max(dfs(nums, index - 1, index, dp) + 1, dfs(nums, index - 1, pre, dp));
        }
        ans = Math.max(ans, dfs(nums, index - 1, pre, dp));
        if (pre != -1) {
            dp[index][pre] = ans;
        }
        return ans;
    }
}