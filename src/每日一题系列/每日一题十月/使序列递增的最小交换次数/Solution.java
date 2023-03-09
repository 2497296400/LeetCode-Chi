package 每日一题系列.每日一题十月.使序列递增的最小交换次数;

import java.util.Arrays;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] arr1 = {4, 4, 5, 7, 11, 14, 15, 16, 17, 20};

//        int[] arr = {0, 4, 4, 5, 9};
//        int[] arr1 = {0, 1, 6, 8, 10};

        System.out.println(solution.minSwap(arr, arr1));
    }

    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp1 = new int[nums2.length][2];
        for (int[] ints : dp1) {
            Arrays.fill(ints, -1);
        }

        return fun(nums1, nums2, 0, 0, dp1);
    }

    private int fun(int[] nums1, int[] nums2, int end, int status, int[][] dp) {
        if (end == nums1.length) {
            return 0;
        }
        if (dp[end][status] != -1) {
            return dp[end][status];
        }
        int p1 = Integer.MAX_VALUE;
        if (end == 0 ||(nums1[end] > nums1[end - 1] && nums2[end] > nums2[end - 1])) {
            p1 = fun(nums1, nums2, end + 1, 0, dp);
        }
        int p2 = Integer.MAX_VALUE;

        if (end == 0 || (nums1[end] > nums2[end - 1] && nums2[end] > nums1[end - 1])) {
            swap(nums1, nums2, end);
            p2 = fun(nums1, nums2, end + 1, 1, dp) + 1;
            swap(nums1, nums2, end);
        }

        dp[end][status] = Math.min(p1, p2);
        return Math.min(p1, p2);
    }

    private void swap(int[] nums1, int[] nums2, int end) {
        int temp = nums2[end];
        nums2[end] = nums1[end];
        nums1[end] = temp;
    }
}