package 动态规划问题.可被三整除的最大和;

import java.util.Arrays;

public class Solution {

    int[][] dp;

    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        this.dp = dp;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(nums, 0, 0);
    }

    private int fun(int[] nums, int index, int  mod) {
        if (index == nums.length) {
            return mod == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[index][ mod] != -1) {
            return dp[index][mod];
        }
        //就是要不要当前位置 然后递归
        int f = fun(nums, index + 1, (mod + nums[index]) % 3)+nums[index];
        int s = fun(nums, index + 1, mod);
        return  dp[index][mod] = Math.max(f, s);
    }
}
