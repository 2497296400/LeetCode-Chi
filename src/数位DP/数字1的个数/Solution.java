package 数位DP.数字1的个数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countDigitOne(13));
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][1 << 10];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return fun(chars, 0, 0, false, true, dp);
    }

    private int fun(char[] chars, int cur, int mark, boolean isNum, boolean isLim, int[][] dp) {
        if (cur == chars.length) {
            return mark;
        }
        if (isNum && !isLim && dp[cur][mark] != -1) {
            return dp[cur][mark];
        }
        int ans = 0;
        if (!isNum) {
            ans = fun(chars, cur + 1, mark, false, false, dp);
        }
        int up = isLim ?  chars[cur] - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            ans += fun(chars, cur + 1, mark + (i == 1 ? 1 : 0), true, isLim && i == up, dp);
        }
        if (isNum && !isLim) {
            dp[cur][mark] = ans;
        }
        return ans;
    }
}
