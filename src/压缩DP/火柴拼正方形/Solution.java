package 压缩DP.火柴拼正方形;

import java.util.Arrays;

public class Solution {
    int target;
    int status = 0;
    int[] dp;
    int end;

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        target = sum / 4;
        dp = new int[1 << matchsticks.length];
        end = (1 << matchsticks.length) - 1;
        return  tofun(matchsticks, 0, status, 4,dp);
    }

    private boolean tofun(int[] matchsticks, int curSum, int status, int rem, int[] dp) {
        if(dp[status]!=0){
            return dp[status]==1;
        }
        if (rem == 0) {
            return status == end;
        }
        boolean ans = false;
        for (int i = 0; i < matchsticks.length; i++) {
            if (matchsticks[i] + curSum > target) {
                continue;
            }
            if ((status & (1 << i)) == 0) {
                if(curSum+matchsticks[i]==target){
                    ans|=tofun(matchsticks, 0, status|(1<<i), rem-1, dp);
                }else {
                    ans|=tofun(matchsticks, curSum+matchsticks[i],status|(1<<i),rem, dp);
                }
            }
        }
        dp[status]= ans?1:-1;
        return ans;
    }
    private boolean fun(int[] matchsticks, int curSum, int status) {
        if (status == end) {
            return true;
        }
        if (dp[status] != 0) {
            return false;
        }
        for (int i = 0; i < matchsticks.length; i++) {
            if (matchsticks[i] + curSum > target) {
                break;
            }
            if ((status & (1 << i)) == 0) {
                dp[status] = 1;
                if (fun(matchsticks, (curSum + matchsticks[i]) % target, status | (1 << i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
