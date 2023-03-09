package 滑动窗口.乘积小于K的子数组;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //连续的子数组,乘积严格小于 k
        int length = nums.length;
        int count = 0;
        int mul_temp = 1;
        if (k <= 0) {
            return 0;
        }
        int l = 0;
        //  int r = 0;
        int mul = 1;
        for (int r = 0; l < length && r < length; r++) {
            mul = mul * nums[r];
            while (mul >= k && l <= r) {// && l<=r 注意！
                mul = mul / nums[l];
                l++;
            }
            count += r - l + 1;
            //每次增加个数 等于区间长度
        }
        return count;
    }
}