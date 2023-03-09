package 每日一题系列.每日一题七月.最长特殊子序列;

public class Solution {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c", "a", "b", "c"};
        System.out.println(findLUSlength(str));
    }
    public static int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            char[] charsFirst = strs[i].toCharArray();
            int flag = 0;
            for (int j = 0; j < strs.length; j++) {
                if (j != i) {
                    int curStart = 0;
                    char[] charsSecond = strs[j].toCharArray();
                    for (char c : charsSecond) {
                        if (curStart < charsFirst.length && charsFirst[curStart] == c) {
                            curStart++;
                        }
                    }
                    if (curStart == charsFirst.length) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                max = Math.max(max, charsFirst.length);
            }
        }
        return max;
    }
}
