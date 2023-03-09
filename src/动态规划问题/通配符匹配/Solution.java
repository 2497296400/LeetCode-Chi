package 动态规划问题.通配符匹配;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aa";
        String p = "*";

        System.out.println(solution.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        return fun(chars, 0, chars1, 0, dp);
    }

    private boolean fun(char[] f, int fc, char[] s, int sc, int[][] dp) {
        if (fc == f.length) {
            for (int i = sc; i < s.length; i++) {
                if (s[i] != '*') {
                    return false;
                }
            }
            return true;
        } else if (fc == f.length) {
            return false;
        } else if (sc == s.length) {
            return false;
        }
        if (dp[fc][sc] != 0) {
            return dp[fc][sc] == 1;
        }
        boolean ans = false;
        if (f[fc] == s[sc] || s[sc] == '?') {
            ans= fun(f, fc + 1, s, sc + 1, dp);
        }

        if (s[sc] == '*') {
            ans = fun(f, fc + 1, s, sc, dp);
            ans |= fun(f, fc, s, sc + 1, dp);
        }
        dp[fc][sc] = ans ? 1 : -1;
        return ans;
    }
}
