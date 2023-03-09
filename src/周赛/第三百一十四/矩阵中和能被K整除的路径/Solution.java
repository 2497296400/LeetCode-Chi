package 周赛.第三百一十四.矩阵中和能被K整除的路径;

public class Solution {
    public int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        System.out.println(solution.numberOfPaths(g, 3));
    }

    public int numberOfPaths(int[][] grid, int k) {
        int[][][] map = new int[grid.length][grid[0].length][100001];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                for (int h = 0; h < map[0][0].length; h++) {
                    map[i][j][h] = -1;
                }
            }
        }
        return fun(0, 0, grid[0][0], k, grid, map);
    }

    private int fun(int i, int j, int sum, int k, int[][] grid, int[][][] map) {
        if (map[i][j][sum] != -1) {
            return map[i][j][sum];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return sum % k == 0 ? 1 : 0;
        }
        long ans = 0;
        if (i + 1 < grid.length) {
            ans += fun(i + 1, j, sum + grid[i + 1][j], k, grid, map);
        }
        if (j + 1 < grid[0].length) {
            ans += fun(i, j + 1, sum + grid[i][j + 1], k, grid, map);
        }
        map[i][j][sum] = (int) (ans % MOD);
        return (int) (ans % MOD);
    }
}
