package 每日一题系列.每日一题十二月.构造字典序最大的合并字符串;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String f = "abcabc";
        String s = "abdcaba";
        System.out.println(solution.largestMerge(f, s));
    }

    public String largestMerge(String word1, String word2) {
        StringBuilder first = new StringBuilder(word1);
        StringBuilder second = new StringBuilder(word2);
        char[] chars = word1.toCharArray();

        Deque<String> stack = new LinkedList<>();
        while (first.length() > 0 && second.length() > 0) {
            char temp;
            if (first.compareTo(second) <0) {
                temp = second.charAt(0);
                second.deleteCharAt(0);
            } else {
                temp = first.charAt(0);
                first.deleteCharAt(0);
            }
            stack.addLast(String.valueOf(temp));
        }
        if (first.length() > 0) {
            stack.addLast(first.toString());
        }
        if (second.length() > 0) {
            stack.addLast(second.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollFirst());
        }
        return stringBuilder.toString();
    }
}
