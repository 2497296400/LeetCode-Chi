package 深度广度遍历问题.被围绕的区域;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {{'O', 'O'}, {'O', 'O'}};
        char[][] chars = new Solution().solve(board);
        System.out.println(Arrays.deepToString(chars));
    }
    public char [][] solve(char[][] board) {
        int[] x = {1, 0, 0, -1};
        int[] y = {0, 1, -1, 0};
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[]{i, n - 1});
                board[i][n - 1] = 'A';
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                board[0][i] = 'A';

            }
            if (board[m - 1][i] == 'O') {
                queue.add(new int[]{n - 1, i});
                board[m - 1][i] = 'A';
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = x[i] + poll[0];
                int dy = y[i] + poll[1];
                if (dx >= m || dy >= n || dx < 0 || dy < 0 || board[dx][dy] != 'O') {
                    continue;
                }
                queue.add(new int[]{dx, dy});
                board[dx][dy] = 'A';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }
}
