package 每日一题系列.每日一题三月.最短公共超序列;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestCommonSupersequence("abac", "cab"));
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        char[] f = str1.toCharArray();
        char[] s = str2.toCharArray();
        String[][] dp = new String[f.length][s.length];
        String maxSuq = getMax(f, s, f.length - 1, s.length - 1, dp);
        String cur = getMaxPro(str1, str2, f.length-1,s.length -1,  dp);
        System.out.println(cur);
        char[] maxC = maxSuq.toCharArray();
        int l = 0;
        int r = 0;
        int curLen = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (l < str1.length() && r < str2.length() && curLen < maxC.length) {
            if (f[l] != maxC[curLen]) {
                stringBuilder.append(f[l++]);
            } else if (s[r] != maxC[curLen]) {
                stringBuilder.append(s[r++]);
            } else {
                stringBuilder.append(maxC[curLen]);
                l++;
                r++;
                curLen++;
            }
        }
        while (l < str1.length()) {
            stringBuilder.append(str1.charAt(l++));
        }
        while (r < str2.length()) {
            stringBuilder.append(str2.charAt(r++));
        }
        return String.valueOf(stringBuilder);
    }

    private String getMax(char[] f, char[] s, int fLen, int sLen, String[][] dp) {
        if (fLen < 0 || sLen < 0) {
            return "";
        }
        if (dp[fLen][sLen] != null && dp[fLen][sLen] != "") {
            return dp[fLen][sLen];
        }
        if (f[fLen] == s[sLen]) {
            dp[fLen][sLen] = getMax(f, s, fLen - 1, sLen - 1, dp) + f[fLen];
            return dp[fLen][sLen];
        }
        String fStr = getMax(f, s, fLen - 1, sLen, dp);
        String sStr = getMax(f, s, fLen, sLen - 1, dp);
        dp[fLen][sLen] = fStr.length() > sStr.length() ? fStr : sStr;
        return dp[fLen][sLen];
    }

    private String getMaxPro(String f, String s, int flen, int slen, String[][] dp) {
        if (flen < 0) {
            return s.substring(0, slen+1);
        }
        if (slen < 0) {
            return f.substring(0, flen+1);
        }
        if (f.charAt(flen) == s.charAt(slen)) {
            return getMaxPro(f, s, flen - 1, slen - 1, dp) + f.charAt(flen);
        }
        String fStr = getMaxPro(f, s, flen - 1, slen, dp) + f.charAt(flen);
        String sStr = getMaxPro(f, s, flen, slen - 1, dp) + s.charAt(slen);
        return fStr.length() < sStr.length() ? fStr : sStr;
    }
}
