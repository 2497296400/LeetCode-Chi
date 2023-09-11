package 动态规划难搞类.戳气球;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums));
    }

    private int ans = 0;

    public int maxCoins(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(num);
        }
        fun(arrayList, 0);
        arrayList.add(0, 1);
        arrayList.add(1);
        int[][] dp = new int[arrayList.size()][arrayList.size()];
        return toGetFun(arrayList, 0, arrayList.size() - 1, dp);
    }

    //记忆化搜索
    private int toGetFun(ArrayList<Integer> arrayList, int i, int j, int[][] dp) {
        if (i == j - 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        for (int cur = i + 1; cur < j; cur++) {
            int left = toGetFun(arrayList, i, cur, dp);
            int right = toGetFun(arrayList, cur, j, dp);
            int curData = arrayList.get(cur) * arrayList.get(i) * arrayList.get(j);
            dp[i][j] = Math.max(dp[i][j], left + right + curData);
        }
        return dp[i][j];
    }

    //回溯
    private void fun(ArrayList<Integer> arrayList, int curSum) {
        if (arrayList.size() == 0) {
            ans = Math.max(ans, curSum);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            int temp = arrayList.get(i);
            int cur = arrayList.get(i) * (i - 1 >= 0 ? arrayList.get(i - 1) : 1) * (i + 1 < arrayList.size() ? arrayList.get(i + 1) : 1);
            arrayList.remove(i);
            fun(arrayList, curSum + cur);
            arrayList.add(i, temp);
        }
    }
}
