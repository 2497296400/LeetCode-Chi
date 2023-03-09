package 最长回文子串;

class Solution {
    int start = 0;
    int end = 0;
    int length = 0;
    char[] cs = null;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        cs = s.toCharArray();
        length = cs.length;
        fill(0);
        return s.substring(start, end + 1);
    }
    private int fill(int i) {
        if (i + 1 == length || 2 * (length - i) + 1 < end - start) {
            return 0;
        }
        int cur_end = i;
        int cur_start = i;
        while (cur_end < length - 1 && cs[cur_end] == cs[cur_end + 1]) {
            cur_end++;
        }
        i = cur_end;
        while (cur_start > 0 && cur_end < length - 1 && cs[cur_start - 1] == cs[cur_end + 1]) {
            cur_start--;
            cur_end++;
        }
        if (cur_end - cur_start > end - start) {
            end = cur_end;
            start = cur_start;
        }
        return fill(i + 1);
    }
}