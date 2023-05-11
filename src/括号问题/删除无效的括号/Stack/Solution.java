package 括号问题.删除无效的括号.Stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRightParentheses("(()))(()("));
    }
    public String getRightParentheses(String s) {
        char[] array = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int l = 0;
        while (l < array.length) {
            while (l<array.length&&array[l] == '(') {
                stack.add(array[l++]);
            }
            int len = 0;
            while (l<array.length&&array[l] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stringBuilder.append(stack.pop());
                    len++;
                }
                l++;
            }
            stringBuilder.append(")".repeat(len));
        }
        return stringBuilder.toString();
    }
}