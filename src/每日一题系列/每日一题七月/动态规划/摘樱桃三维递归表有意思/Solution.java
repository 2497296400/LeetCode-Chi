package 每日一题系列.每日一题七月.动态规划.摘樱桃三维递归表有意思;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grig = {{0, 1, -1}
                , {1, 0, -1},
                {1, 1, 1}};
        System.out.println(solution.cherryPickup(grig));
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n * 2 - 1][n][n];
        for (int i = 0; i < n * 2 - 1; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
            }
        }
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); ++x1) {
                int y1 = k - x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = x1; x2 <= Math.min(k, n - 1); ++x2) {
                    int y2 = k - x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }
                    int res = f[k - 1][x1][x2]; // 都往右
                    if (x1 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2]); // 往下，往右
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[k - 1][x1][x2 - 1]); // 往右，往下
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2 - 1]); // 都往下
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) { // 避免重复摘同一个樱桃
                        res += grid[x2][y2];
                    }
                    f[k][x1][x2] = res;
                }
            }
        }
        System.out.println(fun(grid, 0, 0, 0));
        return Math.max(f[n * 2 - 2][n - 1][n - 1], 0);
    }

    public int fun(int[][] grid, int a, int b, int c) {
        int M = grid.length - 1;
        int N = grid[0].length - 1;
        if (a == M && b == N) {
            return grid[a][b];
        }
        int best = 0;
        if (a < M) {
            if (c < M) {
                best = Math.max(best, fun(grid, a + 1, b, c + 1));
            }
            if (a + b - c < N) {
                best = Math.max(best, fun(grid, a + 1, b, c));
            }
        }
        if (b < N) {
            if (c < M) {
                best = Math.max(best, fun(grid, a, b + 1, c + 1));
            }
            if (a + b - c < N) {
                best = Math.max(best, fun(grid, a, b + 1, c));
            }
        }
        if (grid[a][b] == -1 || grid[c][a+b-c] == -1) {
            return -1;
        }
        int cur;
        if (a == c) {
            cur = grid[a][b];
        } else {
            cur = grid[a][b] + grid[c][a+b-c];
        }
        return best + cur;
    }
}
