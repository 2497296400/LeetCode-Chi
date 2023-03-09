package 每日一题系列.每日一题十月.检查二进制字符串字段;

public class Solution {
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        boolean f = false;
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length && f && chars[i] == '1') {
                return false;
            }
            while (i < chars.length && chars[i] == '1') {
                i++;
                f = true;
            }
        }
        return true;
    }
}
