package 括号问题.最长有效括号;

import java.util.Arrays;

public class 记忆化搜索 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new 记忆化搜索().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        int[] memo = new int[charArray.length];
        Arrays.fill(memo, -1);
        for (int i = 1; i < charArray.length; i++) {
            ans = Math.max(ans, fun(i, charArray, memo));
        }
        return ans;
    }

    private int fun(int index, char[] c, int[] memo) {
        if (index <= 0) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int max = 0;
        if (c[index] == ')') {
            int 连续右括号 = fun(index - 1, c, memo);
            int 左括号位置 = index - 连续右括号 - 1;
            if (左括号位置 >= 0 && c[左括号位置] == '(') {
                max = 连续右括号 + 2 + fun(左括号位置 - 1, c, memo);
            }
        }
        return memo[index] = max;
    }
}
