package 精选一百道题.除自身以外数组的乘积;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
       Solution solution= new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] start = new int[nums.length];
        start[0] = nums[0];
        int[] end = new int[nums.length];
        end[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1, j = nums.length - 1; i < nums.length && j >= 1; i++, j--) {
            start[i] = start[i - 1] * nums[i];
            end[j - 1] = end[j] * nums[j-1];
        }
        int[] ans = new int[nums.length];
        ans[0] = end[1];
        ans[nums.length - 1] = start[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = start[i - 1] * end[i + 1];
        }
        return ans;
    }
}
