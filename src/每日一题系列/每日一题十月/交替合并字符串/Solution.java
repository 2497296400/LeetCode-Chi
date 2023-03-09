package 每日一题系列.每日一题十月.交替合并字符串;

public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int len1 = 0;
        while (len1 < word1.length() && len1 < word2.length()) {
            stringBuilder.append(word1.charAt(len1)).append(word2.charAt(len1));
            len1++;
        }
        if (len1 != word1.length()) {
            stringBuilder.append(word1.substring(len1));
        }
        if (len1 != word2.length()) {
            stringBuilder.append(word2.substring(len1));
        }
        return String.valueOf(stringBuilder);
    }
}
