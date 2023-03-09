package 左神算法集.有多少子序列可以构成s2;

import java.util.Arrays;

public class Solution {
    public int sum = 0;
    public int ans = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "1122";
        String s2 = "12";
        System.out.println(solution.getAns(s1, s2));
    }

    public int getAns(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        if (c2[0] == c1[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i][0] = c1[i] == c2[0] ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }
        for (int i = 1; i < dp.length - 1; i++) {
            for (int j = 1; j <= i && j < c2.length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (c1[i] == c2[j]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        int[][] sr = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i < sr.length; i++) {
            for (int j = 0; j < sr[0].length; j++) {
                sr[i][j] = -1;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(ans);
        return dp[c1.length - 1][c2.length - 1];
    }
}
