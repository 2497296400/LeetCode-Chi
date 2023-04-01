package 每日一题系列.每日一题四月.隐藏个人信息;

public class Solution {

    public String maskPII(String s) {
        String aCase = s.toLowerCase();
        int indexOf = aCase.indexOf("@");
        if (indexOf > 0) {
            return s.charAt(0) + "*****" + s.charAt(indexOf - 1) + s.substring(indexOf).toLowerCase();
        }
        String replaceAll = s.replaceAll("[^0-9]", "");
        String[] c = {"", "+*-", "+**-", "+***-"};
        return c[replaceAll.length() - 10] + "***-***" + s.substring(s.length() - 4);
    }
}