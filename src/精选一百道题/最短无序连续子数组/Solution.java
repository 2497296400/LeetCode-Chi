package 精选一百道题.最短无序连续子数组;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length ;
        if (len == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[len-1];
        int hight = 0;
        int low = len;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i-1]);
            if (nums[i] < max) {
                hight = i;
            }
            if (nums[len - i-1] > min) {
                low = len - i-1;
            }
        }
        return hight > low ? hight - low +1: 0;
    }
}



