package 动态规划问题.打家劫舍二;

import java.util.Arrays;
//环形
class Solution {
    public static void main(String[] args) {
        int []nums={1,2,3,1,5};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
     if(nums.length==1){
         return nums[0];
     }
     else if(nums.length==2){
         return Math.max(nums[0],nums[1]);
     }
     return Math.max(robFind(nums,0,nums.length-1),robFind(nums,1,nums.length));
}

    private static int robFind(int[] nums, int strat, int end) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,0);
        dp[strat]=nums[strat];
        dp[strat+1]=Math.max(nums[strat],nums[strat+1]);
        for(int i=strat+2;i<end;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end-1];
    }
    }