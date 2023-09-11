package 灵神总结周赛.动态规划.网格图中递增路径的数目;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{1}, {2}};
        System.out.println(solution.countPaths(g));
    }

    public int countPaths(int[][] grid) {
        long ans = 0;
        long[][] dp = new long[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = (ans + fun(i, j, grid, dp) % MOD);
            }
        }
        return (int) ans;
    }

    int[][] v = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private long fun(int i, int j, int[][] grid, long[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //精髓 也是当前状态
        Queue<String> q =new LinkedList<>();
        long res = 1;
        for (int c = 0; c < 4; c++) {
            int[] ints = v[c];
            int x = i + ints[0];
            int y = j + ints[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] > grid[i][j]) {
                res = (res + fun(x, y, grid, dp)) % MOD;
            }
        }
        return dp[i][j] = res % MOD;
    }
}
