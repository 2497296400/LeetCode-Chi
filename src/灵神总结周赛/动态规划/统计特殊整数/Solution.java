package 灵神总结周赛.动态规划.统计特殊整数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSpecialNumbers(20));
    }

    public int countSpecialNumbers(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Integer[][] dp = new Integer[chars.length][1 << 9 + 1];
        return fun(chars, 0, 0, false, true, dp);
    }

    private int fun(char[] chars, int index, int status, boolean isNum, boolean isLim, Integer[][] dp) {
        if (index == chars.length) {
            return isNum ? 1 : 0;
        }
        if (isNum && !isLim && dp[index][status] != null) {
            return dp[index][status];
        }
        int ans = 0;
        ans += fun(chars, index + 1, status, false, false, dp);
        int strat = isNum ? 0 : 1;
        int up = isLim ? chars[index] - '0' : 9;
        for (int i = strat; i <= up; i++) {
            if ((status & (1 << i)) == 0) {
                ans += fun(chars, index + 1, status | (1 << i), true, isLim && i == up, dp);
            }
        }
        if (isNum && !isLim) {
            dp[index][status] = ans;

        }
        return ans;
    }
}
