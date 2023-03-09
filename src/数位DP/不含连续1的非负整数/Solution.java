package 数位DP.不含连续1的非负整数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findIntegers(5));

    }

    public int findIntegers(int n) {
        int curIndex = 31;
        while (((n >> curIndex) & 1) == 0) curIndex--;
        Integer[][] dp = new Integer[ curIndex+1][2];
        return fun(0, curIndex, true, n, dp);
    }

    private int fun(int pre, int curIndex, boolean isLimit, int n, Integer[][] dp) {
        if (curIndex < 0) {
            return 1;
        }
        if (!isLimit && dp[curIndex][pre] != null) {
            return dp[curIndex][pre];
        }
        int ans = 0;
        if (pre == 1) {
            ans += fun(0, curIndex - 1, isLimit && (n & (1 << curIndex)) == 0, n, dp);
        } else {
            if (isLimit) {
                if (((n >> curIndex) & 1) == 1) {
                    ans += fun(1, curIndex - 1, isLimit, n, dp);
                }
                ans += fun(0, curIndex - 1, isLimit && (n & (1 << curIndex)) == 0, n, dp);
            } else {
                ans += fun(0, curIndex - 1, isLimit, n, dp);
                ans += fun(1, curIndex - 1, isLimit, n, dp);
            }
        }
        if (!isLimit) {
            dp[curIndex][pre]=ans;
        }
        return ans;
    }
}
