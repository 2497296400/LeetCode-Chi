package 精选一百道题.动态规划类.最大正方形;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    ans = Math.max(ans, fun(matrix, i, j, dp));
                }
            }
        }
        return ans * ans;
    }

    private int fun(char[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int curAns = 0;
        if (matrix[i][j] == '1') {
            curAns = 1;
            int left = fun(matrix, i, j - 1, dp);
            int up = fun(matrix, i - 1, j, dp);
            int leftUp = fun(matrix, i - 1, j - 1, dp);
            curAns += Math.min(left, Math.min(up, leftUp));
        }
        return dp[i][j] = curAns;
    }
}

