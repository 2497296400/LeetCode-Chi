package 每日一题系列.每日一题八月.找出与数组相加的整数II;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {9, 9, 1, 1, 1};
        int[] nums2 = {5, 5, 5};
        System.out.println(solution.minimumAddedInteger(nums1, nums2));
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int lenOne = nums1.length - 1;
        int lenTow = nums2.length - 1;
        int deepOne = nums2[lenTow] - nums1[lenOne];
        int deepTow = nums2[lenTow] - nums1[lenOne - 1];
        int deepThree = nums2[lenTow] - nums1[lenOne - 2];
        int l = 0, r = nums1.length;
        for (int i = lenTow; i >= 0; i--) {
            int target = nums2[i] - deepOne;
            r = getIndex(nums1, l, r, target);
            if (r < 0) {
                deepOne = Integer.MAX_VALUE;
                break;
            }
        }
        r = nums1.length;
        for (int i = lenTow; i >= 0; i--) {
            int target = nums2[i] - deepTow;
            r = getIndex(nums1, l, r, target);
            if (r < 0) {
                deepTow = Integer.MAX_VALUE;
                break;
            }
        }
        r = nums1.length;
        for (int i = lenTow; i >= 0; i--) {
            int target = nums2[i] - deepThree;
            r = getIndex(nums1, l, r, target);
            if (r < 0) {
                deepThree = Integer.MAX_VALUE;
                break;
            }
        }

        return Math.min(deepOne, Math.min(deepTow, deepThree));
    }

    private int getIndex(int[] nums, int l, int r, int target) {
        int left = 0, right = r - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid; // Update result to the current mid
                left = mid + 1; // Move to the right half to find the rightmost target
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
