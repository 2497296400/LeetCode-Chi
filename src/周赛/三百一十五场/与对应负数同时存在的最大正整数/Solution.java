package 周赛.三百一十五场.与对应负数同时存在的最大正整数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                break;
            } else {
                set.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (set.contains(-nums[i])) {
                    max = nums[i];
                }
            }
        }
        return max;
    }
}
