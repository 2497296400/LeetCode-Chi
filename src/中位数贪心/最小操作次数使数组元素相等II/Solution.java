package 中位数贪心.最小操作次数使数组元素相等II;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int targetF = nums[n];
        int targetS = nums[(n - nums.length & 1) == 0 ? 1 : 0];
        long ansf = 0;
        long ansS = 0;

        for (int num : nums) {
            ansf += Math.abs(num - targetF);
            ansS += Math.abs(num - targetS);
        }
        return (int) Math.min(ansf, ansS);
    }
}
