package 精选一百道题.动态规划类.最长公共子序列;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abcdsafg";
        String s2 = "abcasdfas";
        System.out.println(solution.longestCommonSubsequence(s1, s2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars = text1.toCharArray();
        int endF = chars.length - 1;
        char[] chars1 = text2.toCharArray();
        int endS = chars1.length - 1;
        int[][] dp = new int[endF + 1][endS + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int fun = fun(chars, chars1, endF, endS, dp);
        ArrayList<Character> path = new ArrayList<>();
        ArrayList<ArrayList<Character>> all = new ArrayList<>();
        toGetALl(chars, chars1, endF, endS, dp, path, all);
        System.out.println(all);
        return fun;
    }

    private void toGetALl(char[] f, char[] s, int endF, int endS, int[][] dp, ArrayList<Character> path, ArrayList<ArrayList<Character>> all) {
        if (endF == endS && endF == 0) {
            if (dp[endF][endS] > 0) {
                path.add(f[endF]);
                all.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            } else {
                all.add(new ArrayList<>(path));
            }
        } else {
            if (dp[endF][endS] == dp[endF - 1][endS - 1] + 1 && f[endF] == s[endS]) {
                path.add(f[endF]);
                toGetALl(f, s, endF - 1, endS - 1, dp, path, all);
                path.remove(path.size() - 1);
            }
            if (dp[endF][endS] == dp[endF - 1][endS]) {
                toGetALl(f, s, endF - 1, endS, dp, path, all);
            }
            if (dp[endF][endS] == dp[endF][endS - 1]) {
                toGetALl(f, s, endF, endS - 1, dp, path, all);
            }
        }
    }

    private int fun(char[] first, char[] second, int endF, int endS, int[][] dp) {
        if (endF < 0 || endS < 0) {
            return 0;
        }
        if (dp[endF][endS] != -1) {
            return dp[endF][endS];
        }
        if (endF == endS && endF == 0) {
            dp[endF][endS] = first[endF] == second[endS] ? 1 : 0;
            return dp[endF][endS];
        }
        if (first[endF] == second[endS]) {
            dp[endF][endS] = fun(first, second, endF - 1, endS - 1, dp) + 1;
            return dp[endF][endS];
        }
        int p1 = 0;
        int p2 = 0;
        if (endS > 0) {
            p1 = fun(first, second, endF, endS - 1, dp);
        }
        if (endF > 0) {
            p2 = fun(first, second, endF - 1, endS, dp);
        }
        dp[endF][endS] = Math.max(p1, p2);
        return dp[endF][endS];
    }
}