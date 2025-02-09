package 每日一题系列.每日一题二月.不同路径II;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(obstacleGrid, 0, 0, dp);
    }

    private int fun(int[][] obstacleGrid, int x, int y, int[][] dp) {
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (x == obstacleGrid.length-1 && y == obstacleGrid[0].length-1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = fun(obstacleGrid, x + 1, y, dp) + fun(obstacleGrid, x, y + 1, dp);
        return dp[x][y];
    }
}
