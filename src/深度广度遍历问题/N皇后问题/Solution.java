package 深度广度遍历问题.N皇后问题;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solveNQueens2(14);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        for (List<String> solution : solutions) {
            for (String s : solution) {
                System.out.println(s);
            }
            System.out.println("-----------------------------");
        }
        return solutions;
    }

    private static void backtrack(List<List<String>> solutions, int[] queens, int n, int row,
                                  Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            solutions.add(new ArrayList<>(generateBoard(queens, n)));
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int digonall1 = row - i;
                if (diagonals1.contains(digonall1)) {
                    continue;
                }
                int digonall2 = row + i;
                if (diagonals2.contains(digonall2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(digonall1);
                diagonals2.add(digonall2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(digonall1);
                diagonals2.remove(digonall2);
            }
        }
    }

    public static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static List<List<String>> solveNQueens2(int n) {
        int[] recod = new int[n];
        List<List<String>> list = new ArrayList<>();
        process(n, 0, list, recod);
        for (List<String> strings : list) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("========");
        }
        return list;
    }

    private static void process(int n, int row, List<List<String>> list, int[] recod) {
        if (row == n) {
            list.add(new ArrayList<>(generateBoard(recod, n)));
        }
        for (int i = 0; i < n; i++) {
            if (isValid(recod, row, i)) {
                recod[row] = i;
                process(n, row + 1, list, recod);
            }
        }
    }
    public static boolean isValid(int[] record, int row, int j) {
        for (int k = 0; k < row; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(row - k)) {
                return false;
            }
        }
        return true;
    }

}
