package 每日一题系列.每日一题二月.穿过迷宫的最少移动次数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 0}};
        System.out.println(solution.minimumMoves(g));
    }

    public int minimumMoves(int[][] grid) {
        Integer[][][][] dp = new Integer[grid.length][grid[0].length][2][2];
        int dfs = dfs(grid, 0, 0, 0, 1, 0, 0, dp);
        Integer[][][][] dp2 = new Integer[grid.length][grid[0].length][2][2];
        int dfs1 = dfs(grid, 0, 1, 0, 0, dp2);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(Arrays.deepToString(dp2));
        return dfs < Integer.MAX_VALUE / 2 ? dfs : -1;
    }

    private int dfs(int[][] grid, int x1, int y1, int x2, int y2, int status, int preCheck, Integer[][][][] dp) {
        if (x2 < 0 ||
                x2 > grid.length - 1 ||
                 y2 < 0 || y2 > grid[0].length - 1 ||
       grid[x2][y2] == 1) {
            return Integer.MAX_VALUE;
        }
        if (x2 == grid.length - 1 && y2 == grid[0].length - 1 && status == 0) {
            return 0;
        }
        if (dp[x2][y2][status][preCheck] != null) {
            return dp[x2][y2][status][preCheck];
        }
        int ways = Integer.MAX_VALUE / 2;
        if (status == 0) {
            int p1 = dfs(grid, x1, y1 + 1, x2, y2 + 1, 0, 0, dp);
            int p2 = dfs(grid, x1 + 1, y1, x2 + 1, y2, 0, 0, dp);
            int p3 = Math.min(p1, p2);
            if ( x2 < grid.length - 1 && grid[x2 + 1][y2-1] == 0 && grid[x2 + 1][y2] == 0 && preCheck == 0) {
                p3 = Math.min(p3, dfs(grid, x1, y1, x2 + 1, y2 - 1, 1, 1, dp));
            }
            ways = Math.min(ways, p3);
        }
        if (status == 1) {
            int p1 = dfs(grid, x1, y1 + 1, x2, y2 + 1, 1, 0, dp);
            int p2 = dfs(grid, x1 + 1, y1, x2 + 1, y2, 1, 0, dp);
            int p3 = Math.min(p1, p2);
            if ( y2 + 1 < grid[0].length && grid[x2-1][y2 + 1] == 0 && grid[x2][y2 + 1] == 0 && preCheck == 0) {
                p3 = Math.min(p3, dfs(grid, x1, y1, x2 - 1, y2 + 1, 0, 1, dp));
            }
            ways = Math.min(ways, p3);
        }
        dp[x2][y2][status][preCheck] = ways + 1;
        return ways + 1;
    }
    private int dfs(int[][] grid, int x2, int y2, int tail, int preCheck, Integer[][][][] dp) {
        if (x2 < 0 ||
                x2 > grid.length - 1 ||
                y2 < 0 || y2 > grid[0].length - 1 ||
                grid[x2][y2] == 1) {
            return Integer.MAX_VALUE;
        }

        if (x2 == grid.length - 1 && y2 == grid[0].length - 1 && tail == 0) {
            return 0;
        }
        if (dp[x2][y2][tail][preCheck] != null) {
            return dp[x2][y2][tail][preCheck];
        }
        int ways = Integer.MAX_VALUE / 2;

        if (tail == 0) {
            int p1 = dfs(grid, x2 , y2+1, 0, 0, dp);
            int p2 = dfs(grid, x2+1, y2, 0, 0, dp);
            int p3 = Math.min(p1, p2);
            if (x2 < grid.length - 1 && grid[x2 + 1][y2] == 0 && grid[x2 + 1][y2 - 1] == 0 && preCheck == 0) {
                p3 =Math.min(p3, dfs(grid, x2 + 1, y2 - 1, 1, 1, dp));
            }
            ways = Math.min(ways, p3);
        }

        if (tail == 1) {
            int p1 = dfs(grid, x2 , y2+1, 1, 0, dp);
            int p2 = dfs(grid, x2+1, y2 , 1, 0, dp);
            int p3 = Math.min(p1, p2);
            if (x2 > 0 && y2 < grid[0].length - 1 && grid[x2 - 1][y2 + 1] == 0 && grid[x2][y2 + 1] == 0 && preCheck == 0) {
                p3 = Math.min(p3,dfs(grid, x2 - 1, y2 + 1, 0, 1, dp));
            }
            ways = Math.min(p3, ways);
        }

        dp[x2][y2][tail][preCheck] = ways + 1;
        return ways + 1;
    }
}