package 精选一百道题.寻找两个正序数组的中位数;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1, 2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) +
                findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];//nums1为空数组
        }
        if (s2 >= nums2.length) {
            return nums1[s1 + k - 1];//nums2为空数组
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int midVal1 = Integer.MAX_VALUE;
        if (s1 + k / 2 - 1 < nums1.length) {
            midVal1 = nums1[s2 + k / 2 - 1];
        }
        int midVal2 = Integer.MAX_VALUE;

        if (s2 + k / 2 - 1 < nums2.length) {
            midVal2 = nums2[s2 + k / 2 - 1];
        }
        if (midVal1 < midVal2) {
            return findKth(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        } else {
            return findKth(nums1, s1, nums2, s2 + k / 2, k - k / 2);
        }
    }
}
