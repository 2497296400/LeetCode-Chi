package 动态规划问题.最长递增子串个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int []nums={2,2,2,2,2};
        System.out.println(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int[] dp = new int[nums.length];
        int []dpsum=new int[nums.length];
        int max=1;
        Arrays.fill(dp, 1);
        Arrays.fill(dpsum,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        dpsum[i]=dpsum[j];}
                    else if(dp[i]==dp[j]+1){
                        dpsum[i]+=dpsum[j];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==max){
                sum+=dpsum[i];}
        }
        return sum;
    }
}



