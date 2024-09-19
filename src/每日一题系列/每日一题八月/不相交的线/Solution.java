package 每日一题系列.每日一题八月.不相交的线;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(nums1, nums2, 0, 0, dp);
    }

    private int fun(int[] nums1, int[] nums2, int f1, int s1, int[][] dp) {
        if (f1 == nums1.length || s1 == nums2.length) {
            return 0;
        }
        if (dp[f1][s1] != -1) {
            return dp[f1][s1];
        }
        int ans = 0;
        if (nums1[f1] == nums2[s1]) {
            ans = 1 + fun(nums1, nums2, f1 + 1, s1 + 1, dp);
        } else {
            ans = Math.max(fun(nums1, nums2, f1 + 1, s1, dp), fun(nums1, nums2, f1, s1 + 1, dp));
        }
        dp[f1][s1] = ans;
        return ans;
    }
}
