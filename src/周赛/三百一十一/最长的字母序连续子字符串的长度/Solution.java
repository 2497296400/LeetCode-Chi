package 周赛.三百一十一.最长的字母序连续子字符串的长度;

public class Solution {
    public int longestContinuousSubstring(String s) {
        int max = 1;
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return max;
        }
        int start = 0;
        int end = 1;
        while (end < chars.length) {
            if (end < chars.length && chars[end] - 'a' - 1 == chars[end - 1] - 'a') {
                end++;
            } else {
                start = end;
                end++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
