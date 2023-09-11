package 深度广度遍历问题.N皇后问题;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("---------------");
        }
    }

    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        List<String> strings = new ArrayList<>();
        int[] red = new int[n];
        fun(n, 0, strings, red);
        return res;
    }

    private static void fun(int n, int row, List<String> strings, int[] red) {
        if (n == row) {
            res.add(new ArrayList(strings));
        }
        StringBuilder t = new StringBuilder();
        t.append(".".repeat(n));
        for (int i = 0; i < n; i++) {
            t.setCharAt(i, 'Q');
            if (isV(red, row, i)) {
                red[row] = i;
                strings.add(String.valueOf(t));
                fun(n, row + 1, strings, red);
                strings.remove(strings.size() - 1);
            }
            t.setCharAt(i, 'Z');
        }
    }

    private static boolean isV(int[] red, int row, int i) {
        for (int k = 0; k < row; k++) {
            if (red[k] == i || Math.abs(k - row) == Math.abs(red[k] - i)) {
                return false;
            }
        }
        return true;
    }

}
