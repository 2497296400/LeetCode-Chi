package 回文字符串系列.最长回文子序列;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcdeba";
        System.out.println(solution.longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        fun(chars, 0, chars.length - 1, dp);
        char[] str = new char[dp[0][s.length() - 1]];
        int sl = 0;
        int sr = str.length;
        int l = 0;
        int r = s.length() - 1;
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
        return 0;
    }

    private int fun(char[] chars, int left, int right, int[][] dp) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (left == right) {
            return 1;
        }
        if (left == right - 1) {
            return chars[left] == chars[right] ? 2 : 1;
        }
        int p4 = fun(chars, left + 1, right - 1, dp);
        int p1 = fun(chars, left, right - 1, dp);
        int p2 = fun(chars, left + 1, right, dp);
        int p3 = chars[left] == chars[right] ? (2 + fun(chars, left + 1, right - 1, dp)) : 0;
        dp[left][right] = Math.max(p1, Math.max(p2, Math.max(p4, p3)));
        return dp[left][right];
    }
}
