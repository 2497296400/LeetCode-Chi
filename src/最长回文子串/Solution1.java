package 最长回文子串;

public class Solution1 {
    static int start = 0;
    static int end = 0;
    static char[] chars;
    static int length = 0;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        chars = s.toCharArray();
        length = chars.length;
        findStr(0);
        return s.substring(start, end + 1);
    }

    private static int findStr(int i) {
        if (i + 1 == length ) {
            return 0;
        }
        int curStart = i;
        int curEnd = i;
        while (curEnd < length - 1 && chars[curEnd] == chars[curEnd + 1]) {
            curEnd++;
        }

        while (curEnd < length - 1 && curStart > 0 && chars[curStart - 1] == chars[curEnd + 1]) {
            curStart--;
            curEnd++;
        }
        if (curEnd - curStart > end - start) {
            start = curStart;
            end = curEnd;
        }
        findStr(i + 1);
        return 0;
    }
}
