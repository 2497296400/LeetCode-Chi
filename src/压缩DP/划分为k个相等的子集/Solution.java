package 压缩DP.划分为k个相等的子集;

import java.util.Arrays;

public class Solution {
    boolean[] used;
    boolean ans = false;
    boolean[] dp;

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.canPartitionKSubsets(arr, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int target = sum / k;
        if (sum % k != 0) {
            return false;
        }
        int[] dp = new int[1 << nums.length];
        int end = (1 << nums.length) - 1;
        return tofun(nums, 0, 0, k, dp,end,target);
    }

    private boolean fun(int[] nums, int target, int[] dp, int status, int end, int curSum) {
        if (status == end) {
            return true;
        }
        if(dp[status]!=0){
            return false;
        }
        dp[status]=1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + curSum > target) {
                break;
            }
            if ((status & (1 << i)) == 0) {
                if (fun(nums, target, dp, status | (1 << i), end, (curSum + nums[i]) % target)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean tofun(int[] matchsticks, int curSum, int status, int rem, int[] dp, int end, int target) {
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
                    ans|=tofun(matchsticks, 0, status|(1<<i), rem-1, dp, end, target);
                }else {
                    ans|=tofun(matchsticks, curSum+matchsticks[i],status|(1<<i),rem, dp, end, target);
                }
            }
        }
        dp[status]= ans?1:-1;
        return ans;
    }
}
