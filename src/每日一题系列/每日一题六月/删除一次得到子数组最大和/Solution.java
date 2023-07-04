package 每日一题系列.每日一题六月.删除一次得到子数组最大和;

import java.util.Arrays;

public class Solution {
    int[][] memo;
    int[] arr;

    public int maximumSum(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
        }
        return ans;
    }

    private int dfs(int i, int status) {
        if (i < 0) {
            return Integer.MIN_VALUE / 2;
        }
        if (memo[i][status] != Integer.MIN_VALUE) {
            return memo[i][status];
        }
        if (status == 0) {
            return memo[i][status] = Math.max(dfs(i - 1, 0), 0) + arr[i];
        }
        return memo[i][status] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
    }
}