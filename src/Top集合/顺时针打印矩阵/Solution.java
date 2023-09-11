package Top集合.顺时针打印矩阵;

public class Solution {
    public static void main(String[] args) {
        int[][] g = {{1, 2, 3,10}
                , {4, 5, 6,10},
                {7, 8, 9,10}};
        fun(g);
    }

    private static void fun(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int x1 = 0, y1 = 0, x2 = m - 1, y2 = n - 1;
        while (x1 <= x2 && y1 <= y2) {
            print(g, x1++, y1++, x2--, y2--);
        }
    }

    private static void print(int[][] g, int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            System.out.print(g[x1][i] + " ");
        }
        for (int i = x1 + 1; i <= x2; i++) {
            System.out.print(g[i][y2] + " ");
        }
        if (x1 != x2) {
            for (int i = y2 - 1; i >= y1; i--) {
                System.out.print(g[x2][i] + " ");
            }
        }
        if (y1 != y2) {
            for (int i = x2 - 1; i >= x1 + 1; i--) {
                System.out.print(g[i][y1] + " ");
            }
        }
    }
}
