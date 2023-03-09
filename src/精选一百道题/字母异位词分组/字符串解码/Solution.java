package 精选一百道题.字母异位词分组.字符串解码;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a2[c]]";
        System.out.println(solution.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> data = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int base = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                base = base * 10 + aChar - '0';
            } else if (aChar == '[') {
                data.add(base);
                stack.add(ans.toString());
                base = 0;
                ans = new StringBuilder();
            } else if (aChar == ']') {
                ans = new StringBuilder(stack.pop() + ans.toString().repeat(data.pop()));
            } else {
                ans.append(aChar);
            }
        }
        return ans.toString();
    }
}