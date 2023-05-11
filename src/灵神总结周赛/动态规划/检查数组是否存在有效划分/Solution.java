package 灵神总结周赛.动态规划.检查数组是否存在有效划分;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {865579,865579,893593};
        System.out.println(solution.validPartition(arr));
    }

    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return fun(nums, 0,dp);
    }

    private boolean fun(int[] nums, int index, Boolean[] dp) {
        if (index == nums.length) {
            return true;
        }
        boolean ans = false;
        if(dp[index]!=null){
            return  dp[index];
        }
        if (index < nums.length - 1) {
            if (nums[index] == nums[index + 1]) {
                ans = fun(nums, index + 2, dp);
                if (index < nums.length - 2&&nums[index]==nums[index+2]) {
                    ans |= fun(nums, index + 3, dp);
                }
            }
            if (index < nums.length - 2) {
                if (nums[index + 2] - nums[index] == 2 && nums[index + 1] - nums[index] == 1) {
                    ans |= fun(nums, index + 3, dp);
                }
            }
        }
        return dp[index]=ans;
    }
}
