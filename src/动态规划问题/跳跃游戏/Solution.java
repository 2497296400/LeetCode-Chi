package 动态规划问题.跳跃游戏;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1,5,9,1,0,1,0,0,0,0};
        System.out.println(fun(ints, 0, 0));
        System.out.println(canJump(ints));
    }

    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= dp[i - 1]) {
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
                if (dp[i] >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean fun(int[] arr, int start, int curSum) {
        if (start == arr.length - 1) {
            return true;
        }
        int cur = Math.max(curSum, arr[start] + start);
        boolean ans = false;
        if (cur > start) {
            ans = fun(arr, start + 1, cur);
        }
        return ans;
    }
}