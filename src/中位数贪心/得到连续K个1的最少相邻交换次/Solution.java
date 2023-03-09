package 中位数贪心.得到连续K个1的最少相邻交换次;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 0, 0, 1, 0, 1};
        System.out.println(solution.minMoves(arr, 2));
    }

    public int minMoves(int[] nums, int k) {
        ArrayList<Integer> preList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                preList.add(i-preList.size());
            }
        }
        int m = preList.size();
        int[] p = new int[m + 1];
        for (int i = 0; i < m; i++) {
            p[i + 1] = p[i] + preList.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m-k; i++) {
            ans = Math.min(ans, p[i] + p[i + k] - p[i + k / 2] * 2 - preList.get(i + k / 2) * (k & 1));
        }
        return ans;
    }
}
