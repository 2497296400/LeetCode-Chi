package 精选一百道题.动态规划类.目标和;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curDiff = sum - target;
        if (curDiff < 0 || curDiff % 2 != 0) {
            return 0;
        }
        int neg = curDiff/2;
        int [][]dp=new int[nums.length+1][neg+1];
        dp[0][0]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=neg;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][neg];
    }
    private int fun(int[] nums, int start, int target) {
        if (start == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int sum = 0;
        sum += fun(nums, start + 1, target + nums[start]);
        sum += fun(nums, start + 1, target - nums[start]);
        return sum;
    }
}
