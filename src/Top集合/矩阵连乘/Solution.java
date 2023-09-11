package Top集合.矩阵连乘;

public class Solution {
    public static void main(String[] args) {
        int[] g = {10, 100, 5, 50};
        int ans = fun(g);
        System.out.println(ans);
    }

    private static int fun(int[] g) {
        return fun(g, 0, g.length - 1);
    }

    private static int fun(int[] g, int l, int r) {
        if (l == r-1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l+1 ; i < r; i++) {
            int left = fun(g, l, i);
            int right = fun(g, i , r);
            System.out.println(left + " " + right + " " + l + " " + i + " " + r);
            ans = Math.min(ans, left + right + g[l] * g[i] * g[r]);
        }
        return ans;
    }
}
