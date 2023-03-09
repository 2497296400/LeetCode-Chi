package 动态规划问题.等差数列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        numberOfArithmeticSlices(nums);

    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int d = nums[1] - nums[0];
        int ans = 0;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == d) {
                temp++;
            } else {
                d = nums[i] - nums[i - 1];
                temp = 0;
            }
            ans += temp;
        }
        System.out.println(ans);
        return ans;
    }
}


