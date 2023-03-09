package 数位DP.统计特殊整数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSpecialNumbers(20));
    }

    public int countSpecialNumbers(int n) {
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
            return isNum ? 1 : 0;
        }
        if (isNum && !isLim && dp[cur][mark] != -1) {
            return dp[cur][mark];
        }
        int ans = 0;
        if (!isNum) {
            ans = fun(chars, cur + 1, mark, false, false, dp);
        }
        int up = isLim ? (int) chars[cur] - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            if ((mark >> i & 1) == 0) {
                ans += fun(chars, cur + 1, mark | 1 << i, true, isLim && i == up, dp);

            }
        }
        if (isNum && !isLim) {
            dp[cur][mark] = ans;
        }
        return ans;
    }
}
