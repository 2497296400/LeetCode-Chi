package 周赛.三百一十二场.按位与最大的最长子数组;

import java.util.Arrays;
import java.util.OptionalInt;

public class Solution {
    public int longestSubarray(int[] nums) {
        int strat = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int ans = 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                strat = i;
                while (i < nums.length && nums[i++] == max) {
                    end = i;
                }
                ans = Math.max(ans, end - strat + 1);
            }
        }
        return ans;
    }
}
