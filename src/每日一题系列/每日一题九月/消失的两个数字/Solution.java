package 每日一题系列.每日一题九月.消失的两个数字;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2};
        System.out.println(Arrays.toString(solution.missingTwo(arr)));
    }

    public int[] missingTwo(int[] nums) {
        int[] curN = new int[nums.length + 2];
        curN[nums.length + 1] = -1;
        curN[nums.length] = -1;
        for (int i = 0; i < nums.length; i++) {
            curN[i] = nums[i];
        }

        for (int i = 0; i < curN.length; i++) {
            while (curN[i] != -1 && curN[i] != curN[curN[i]-1]) {
                swap(curN, i, curN[i] - 1);
            }
        }
        int[] ans = new int[2];
        int len = 0;
        for (int i = 0; i < curN.length; i++) {
            if (curN[i] == -1) {
                ans[len++] = i + 1;
            }
            if (len == 2) {
                return ans;
            }
        }
        return ans;
    }

    private void swap(int[] curN, int fist, int s) {
        int temp = curN[fist];
        curN[fist] = curN[s];
        curN[s] = temp;
    }
}
