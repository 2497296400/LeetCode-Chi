package 深度广度遍历问题.二进制矩阵中的最短路径;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dre = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int dis = 1;
        if (grid[0][0] != 0) {
            return -1;
        }
        if (m == 1) {
            return 1;
        }
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int c = 0; c < size; c++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                for (int k = 0; k < 8; k++) {
                    int ni = i + dre[k][0];
                    int nj = j + dre[k][1];
                    if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] == 0 && !visited[ni][nj]) {
                        if (ni == m - 1 && nj == n - 1) {
                            return dis + 1;
                        }
                        queue.add(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}
