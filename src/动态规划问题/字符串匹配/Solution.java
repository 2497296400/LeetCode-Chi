package 动态规划问题.字符串匹配;

public class Solution {
    public static void main(String[] args) {
        String s = "aassddd";
        String p = "a*s*d*b*";
        System.out.println(isMatch(s, p));
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        System.out.println(fun2(sChar, pChar, 0, 0));
    }

    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (maches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (maches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    private static boolean maches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static boolean fun(char[] sChar, char[] pChar, int slen, int plen) {
        if (plen == pChar.length) {
            return slen == sChar.length;
        }
        if (plen + 1 == pChar.length || pChar[plen + 1] != '*') {
            return slen != sChar.length && (pChar[plen] == '.' ||
                    pChar[plen] == sChar[slen]) &&
                    fun(sChar, pChar, slen + 1, plen + 1);
        }
        while (slen + 1 != sChar.length && (sChar[slen] == pChar[plen] || pChar[plen] == '.')) {
            if (fun(sChar, pChar, slen, plen + 2)) {
                return true;
            }
            slen++;
        }
        return fun(sChar, pChar, slen, plen + 2);
    }

    public static boolean fun2(char[] sChar, char[] pChar, int slen, int plen) {
        if (plen == pChar.length) {
            return slen == sChar.length;
        }
        if (plen + 1 == pChar.length || pChar[plen + 1] != '*') {
            return slen < sChar.length &&
                    (sChar[slen] == pChar[plen] || pChar[plen] == '.')
                    && fun2(sChar, pChar, slen + 1, plen + 1);
        } else {
            while (slen < sChar.length && (sChar[slen] == pChar[plen] || pChar[plen] == '.')) {
                if (fun2(sChar, pChar, slen, plen + 2)) {
                    return true;
                }
                slen++;
            }
            return fun2(sChar, pChar, slen, plen + 2);
        }
    }

    public static boolean fun3(char[] sChar, char[] pChar, int slen, int plen) {
        if (plen == pChar.length) {
            return slen == sChar.length;
        }
        boolean ans;
        if (plen + 1 == pChar.length || pChar[plen + 1] != '*') {
            return slen != sChar.length && (pChar[plen] == sChar[slen] || pChar[plen] == '.') && fun3(sChar, pChar, slen + 1, plen + 1);
        } else {
            if (slen == sChar.length) {
                ans = fun3(sChar, pChar, slen, plen + 2);
            } else {
                if (pChar[plen] != sChar[slen]) {
                    ans = fun3(sChar, pChar, slen, plen + 2);
                } else {
                    ans = fun3(sChar, pChar, slen, plen + 2) | fun3(sChar, pChar, slen + 1, plen);
                }
            }
        }
        return ans;
    }
}