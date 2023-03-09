package 每日一题系列.每日一题十一月.最大重复子字符串;

public class Solution {
    public int maxRepeating(String sequence, String word) {
        int sum = 0;
        char[] c1 = sequence.toCharArray();
        char[] c2 = word.toCharArray();
        int len = c2.length;
        for (int i = 0; i < c1.length; i++) {
            int cur = 0;
            int curLen = 0;
            for (int j = i; j < c1.length; j++) {
                if (c1[j] != c2[curLen % len]) {
                    break;
                } else {
                    curLen++;
                    if (curLen % len == 0) {
                        cur++;
                    }
                }
            }
            sum=Math.max(sum, cur);
        }
        return sum;
    }}