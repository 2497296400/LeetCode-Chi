package Top集合.解数独;

import static java.util.Arrays.deepToString;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] br = {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        solution.solveSudoku(br);
    }

    public void solveSudoku(String[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] cow = new boolean[9][10];
        boolean[][] burt = new boolean[9][10];
        isValidSudoku(board, row, cow, burt);
        fun(0, 0, board, row, cow, burt);
        System.out.println(deepToString(board));
    }

    private boolean fun(int i, int j, String[][] board, boolean[][] row, boolean[][] cow, boolean[][] burt) {
        if (i == 9) {
            return true;
        }
        int nexti = j != 8 ? i : i+1;
        int nextj = j != 8 ? j+1 : 0;
        if (!board[i][j].equals(".")) {
        return  fun(nexti, nextj, board, row, cow, burt);
        } else {
            for (int num = 1; num <= 9; num++) {
                int bit = 3 * (i / 3) + (j / 3);
                if (!(row[i][num] || cow[j][num] || burt[bit][num])) {
                    row[i][num] = true;
                    burt[bit][num] = true;
                    cow[j][num] = true;
                    board[i][j] = String.valueOf(num);
                    if (fun(nexti, nextj, board, row, cow, burt)) {
                        return true;
                    }
                    row[i][num] = false;
                    burt[bit][num] = false;
                    cow[j][num] = false;
                    board[i][j] = ".";
                }
            }
            return false;
        }
    }

    public void isValidSudoku(String[][] board, boolean[][] row, boolean[][] cow, boolean[][] burt) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != ".") {
                    int bit = 3 * (i / 3) + j / 3;
                    int num = Integer.parseInt(board[i][j]);
                    row[i][num] = true;
                    cow[j][num] = true;
                    burt[bit][num] = true;
                }
            }
        }
    }
}
