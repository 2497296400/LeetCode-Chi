package 动态规划问题.编辑距离;

public class Solution {
    public static void main(String[] args) {
        String str1 = "dinitrophenylhydrazine";

        String str2 = "benzalphenylhydrazone";
        System.out.println(minDistance(str1, str2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        System.out.println(mindp(c1, c2, m, n));
        return minDistanceProcess(c1, c2, m - 1, n - 1);
    }
    private static int minDistanceProcess(char[] c1, char[] c2, int m, int n) {
        if (m == 0 || n == 0) {
            return Math.max(m, n) + 1;
        }
        if (c1[m] == c2[n]) {
            return minDistanceProcess(c1, c2, m - 1, n - 1);
        }
        return 1 + Math.min(Math.min(minDistanceProcess(c1, c2, m - 1, n), minDistanceProcess(c1, c2, m, n - 1)),
                minDistanceProcess(c1, c2, m - 1, n - 1));
    }

    private static int mindp(char[] c1, char[] c2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}