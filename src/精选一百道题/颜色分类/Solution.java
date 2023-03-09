package 精选一百道题.颜色分类;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length;
        int less = start - 1;
        while (start < end) {
            if (nums[start] < 1) {
                swap(nums, ++less, start++);
            } else if (nums[start] > 1) {
                swap(nums, --end, start);
            } else {
                start++;
            }
        }
    }

    public static void swap(int[] nums, int start, int end) {
        nums[start] = nums[end]^nums[start];
        nums[end]  = nums[end]^nums[start];
        nums[start] = nums[end]^nums[start];
    }
}
