package 精选一百道题.动态规划类.让字符串成为回文串的最少插入次数;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcbacasdac";
        System.out.println(solution.minInsertions(s));
    }

    public int minInsertions(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                dp[i][j] = -1;

            }
        }

        int fun = fun(chars, 0, chars.length - 1, dp);
        char[] str = new char[dp[0][s.length() - 1] + s.length()];
        int sl = 0;
        int sr = str.length - 1;
        int l = 0;
        int r = s.length() - 1;
        List<String> list = new LinkedList<>();
        toGetAll(dp, list, sl, sr, l, r, str, chars);
        System.out.println(list);
        str = new char[dp[0][s.length() - 1] + s.length()];
        while (l < r) {
            if (dp[l][r - 1] == dp[l][r] - 1) {
                str[sl++] = chars[r];
                str[sr--] = chars[r--];
            } else if (dp[l + 1][r] == dp[l][r] - 1) {
                str[sl++] = chars[l];
                str[sr--] = chars[l++];
            } else {
                str[sl++] = chars[l++];
                str[sr--] = chars[r--];
            }
        }
        if (l == r) {
            str[sl] = chars[l];
        }

        System.out.println(String.valueOf(str));
        return fun;
    }

    private void toGetAll(int[][] dp, List<String> list, int sl, int sr, int l, int r, char[] str, char[] chars) {
        if (l >= r) {
            if (l == r) {
                str[sl] = chars[l];
            }
            list.add(String.valueOf(str));
        } else {
            if (dp[l][r - 1] == dp[l][r] - 1) {
                str[sl] = chars[r];
                str[sr] = chars[r];
                toGetAll(dp, list, sl + 1, sr - 1, l, r - 1, str, chars);
            }
            if (dp[l + 1][r] == dp[l][r] - 1) {
                str[sl] = chars[l];
                str[sr] = chars[l];
                toGetAll(dp, list, sl + 1, sr - 1, l + 1, r, str, chars);
            }
            if ((dp[l][r] == dp[l + 1][r - 1] || l == r - 1) && str[l] == str[r]) {
                str[sl] = chars[l];
                str[sr] = chars[r];
                toGetAll(dp, list, sl + 1, sr - 1, l + 1, r - 1, str, chars);
            }
        }
    }

    private int fun(char[] chars, int l, int r, int[][] dp) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            dp[l][r] = 0;
            return 0;
        }
        if (l == r - 1) {
            dp[l][r] = chars[l] == chars[r] ? 0 : 1;
            return chars[l] == chars[r] ? 0 : 1;
        }
        int p1;
        if (chars[l] != chars[r]) {
            p1 = Math.min(fun(chars, l + 1, r, dp), fun(chars, l, r - 1, dp)) + 1;
        } else {
            int p2 = Math.min(fun(chars, l + 1, r, dp), fun(chars, l, r - 1, dp)) + 1;
            p1 = Math.min(fun(chars, l + 1, r - 1, dp), p2);
        }
        dp[l][r] = p1;
        return p1;
    }

}
