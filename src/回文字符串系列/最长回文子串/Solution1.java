package 回文字符串系列.最长回文子串;

public class Solution1 {
    static int start = 0;
    static int end = 0;
    static char[] chars;
    static int length = 0;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacaabc"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int l = i / 2, r = l + i % 2;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
