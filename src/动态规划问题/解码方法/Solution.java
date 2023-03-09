package 动态规划问题.解码方法;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
    public static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int sum = process(str, index + 1);
        if (index == str.length - 1) {
            return sum;
        }
        if ((str[index] - '0') * 10 + str[index + 1] - '0' <= 26) {
            sum += process(str, index + 2);
        }
        return sum;
    }
    public static int dp1(char[] chars) {
        int[] dp = new int[chars.length + 1];
        dp[chars.length] = 1;
        dp[chars.length - 1] = chars[chars.length - 1] == '0' ? 0 : 1;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] += dp[i + 1] + (((chars[i] - '0') * 10 + chars[i + 1] - '0') <= 26 ? dp[i + 2] : 0);
            }
        }
        return dp[0];

    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if (s.length() < 1) {
            return 0;
        }
        if (s.length() == 1) {
            if (s.charAt(0) != '0') {
                return 1;
            }
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (((s.charAt(i - 2) - '0') * 10) + (s.charAt(i - 1) - '0')) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(process(s.toCharArray(),0));
        return dp1(s.toCharArray());

    }
}
