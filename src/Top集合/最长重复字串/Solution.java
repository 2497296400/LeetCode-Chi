package Top集合.最长重复字串;

public class Solution {
    public static void main(String[] args) {
        String f = "abab";
        String s = "aaaaabc";
        int ans = fun(f, s, f.length() - 1, s.length() - 1, 0);
        System.out.println(ans);
    }

    private static int fun(String f, String s, int fLen, int sLen, int curSum) {
        if (fLen < 0 || sLen < 0) {
            return curSum;
        }
        int ans = 0;
        if (f.charAt(fLen) == s.charAt(sLen)) {
            ans = fun(f, s, fLen - 1, sLen - 1, curSum + 1);
        }
        return Math.max(ans, Math.max(fun(f, s, fLen - 1, sLen, 0), fun(f, s, fLen, sLen - 1, 0)));
    }
}
