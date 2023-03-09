package 每日一题系列.每日一题十二月.删除字符串两端相同字符后的最短长度;

public class Solution {
    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (chars[l] == chars[r]) {
            char temp = chars[l];
            while (l < chars.length && chars[l] == temp) {
                l++;
            }
            while (r >= 0 && chars[r] == temp) {
                r--;
            }
        }
        return r - l;
    }
}
