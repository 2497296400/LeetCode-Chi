package 精选一百道题.最小路径和;

public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(nums));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length ][grid[0].length ];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] += dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];

        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
