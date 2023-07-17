package 每日一题系列.二零二三年七月.矩阵中的和;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1}};

        System.out.println(solution.matrixSum(nums));
    }

    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < n ;i++) {
            int curMax = 0;
            for (int j = 0; j < nums.length; j++) {
                curMax = Math.max(curMax, nums[j][i]);
            }
            ans += curMax;
        }
        return ans;
    }
}
