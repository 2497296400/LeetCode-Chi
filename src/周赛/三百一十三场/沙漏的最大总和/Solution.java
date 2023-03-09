package 周赛.三百一十三场.沙漏的最大总和;

public class Solution {
    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                max = Math.max(max, fun(grid, i, j));
            }
        }
        return max;
    }

    private int fun(int[][] grid, int i, int j) {
        int sum = 0;
        sum += grid[i][j];
        sum += grid[i][j + 1];
        sum += grid[i][j + 2];
        sum += grid[i + 1][j + 1];
        sum += grid[i + 2][j];
        sum += grid[i + 2][j + 1];
        sum += grid[i + 2][j + 2];
        return sum;
    }
}
