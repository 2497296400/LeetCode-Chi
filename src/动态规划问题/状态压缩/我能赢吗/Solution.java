package 动态规划问题.状态压缩.我能赢吗;

import java.util.HashMap;

public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) >> 1 < desiredTotal) {
            return false;
        }
        int status = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        int[] dp = new int[1 << 20 + 1];
        return fun(desiredTotal, maxChoosableInteger, status, dp);
    }

    private boolean fun(int desiredTotal, int maxChoosableInteger, int status, int[] dp) {
        if (desiredTotal <= 0) {
            dp[status] = -1;
            return false;
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (((1 << i) & status) == 0) {
                if (!fun(desiredTotal - i, maxChoosableInteger, status | (1 << i), dp)) {
                    dp[status] = 1;
                    return true;
                }
            }
        }
        dp[status] = -1;
        return false;
    }
}
