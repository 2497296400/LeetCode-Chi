package 括号问题.最长有效括号;

public class Solution {
    public static void main(String[] args) {
        String s = ")()())";

    }

    public static int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        int pre = 0;
        char[] str = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}