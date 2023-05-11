package 灵神总结周赛.动态规划.不重叠回文子字符串的最大数目;

public class 中心扩散法 {
    //精髓中心扩散
    public int maxPalindromes(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = l + i % 2;
            dp[l + 1] = Math.max(dp[l], dp[l + 1]);
            for (; l >= 0 && r < n && chars[l] == chars[r]; l--, r++) {
                if (r - l + 1 >= k) {
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                    break;
                }
            }
        }
        return dp[n];
    }
}
