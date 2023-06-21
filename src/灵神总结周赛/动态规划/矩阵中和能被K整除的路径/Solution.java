package 灵神总结周赛.动态规划.矩阵中和能被K整除的路径;

public class Solution {
    int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        System.out.println(solution.numberOfPaths(g, 3));
    }
        //可以在参数里面取余
    public int numberOfPaths(int[][] grid, int k) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][k];
        return fun(grid, 0, 0, k, grid[0][0], dp);
    }

    private int fun(int[][] grid, int x, int y, int k, int sum, Integer[][][] map) {
        if (x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return sum % k == 0 ? 1 : 0;
        }
       if (map[x][y][sum%k]!= null) {
            return map[x][y][sum%k];
        }
        int ans = 0;
        if (x + 1 < grid.length) {
            ans += fun(grid, x + 1, y, k, (sum + grid[x + 1][y])%k, map) % MOD;
        }
        if (y + 1 < grid[0].length) {
            ans += fun(grid, x, y + 1, k, (sum + grid[x][y + 1])%k, map) % MOD;
        }
        map[x][y][sum%k]= ans % MOD;
        return ans % MOD;
    }
}
