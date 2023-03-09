package 动态规划问题.不相交的线;

public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        return fun(nums1, nums2, nums1.length - 1, nums2.length - 1, dp);

    }

    private int fun(int[] nums1, int[] nums2, int el, int es, Integer[][] dp) {
        if (el < 0 || es < 0) {
            return 0;
        }
        if (dp[el][es] != null) {
            return dp[el][es];
        }
        int ans = 0;
        int p1 = 0, p2 = 0, p3 = 0;
        if (nums1[el] == nums2[es]) {
            p1 = fun(nums1, nums2, el - 1, es - 1, dp);
        }
        p2 = fun(nums1, nums2, el - 1, es, dp);
        p3 = fun(nums1, nums2, el, es - 1, dp);
        dp[el][es] = Math.max(p1, Math.max(p2, p3));
        return dp[el][es];
    }
}
