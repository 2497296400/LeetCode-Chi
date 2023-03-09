package 数位DP.最大为N的数字组合;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] d = {"1", "3", "5", "7" };
        System.out.println(solution.atMostNGivenDigitSet(d, 100));
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String cur = String.valueOf(n);
        char[] chars = cur.toCharArray();
        int[] dp = new int[cur.length()];
        Arrays.fill(dp, -1);
        return fun(0, digits, chars, true, false, dp);
    }

    private int fun(int i, String[] digits, char[] cur, boolean isLimit, boolean isNum, int[] dp) {
        if (i == cur.length) {
            return isNum ? 1 : 0;
        }
        int ans = 0;
        if (!isNum) {
            ans += fun(i + 1, digits, cur, false, false, dp);
        }
        if (!isLimit && isNum && dp[i] != -1) {
            return dp[i];

        }
        char up = isLimit ? cur[i] : '9';
        for (String digit : digits) {
            if (digit.charAt(0) > up) {
                break;
            }
            ans += fun(i + 1, digits, cur, isLimit && digit.charAt(0) == up, true, dp);
        }
        if (!isLimit && isNum) {
            dp[i] = ans;
        }
        return ans;
    }
}
