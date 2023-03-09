package 精选一百道题.单词搜索;

public class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        char[][] brode = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String word = "ABCCED";
        System.out.println(exist(brode, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (DFS(board, visited, chars, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean DFS(char[][] board, boolean[][] visited, char[] chars, int index, int x, int y) {
        if (board[x][y] != chars[index]) {
            return false;
        } else if (index == chars.length - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean ans = false;
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (curX >= 0 && curY >= 0 && curX < board.length && curY < board[0].length) {
                if (!visited[curX][curY]) {
                    ans = DFS(board, visited, chars, index + 1, curX, curY);
                }
                if (ans == true) {
                    break;
                }
            }
        }
        visited[x][y] = false;
        return ans;
    }
}