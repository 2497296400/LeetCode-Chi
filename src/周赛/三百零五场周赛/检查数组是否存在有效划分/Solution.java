package 周赛.三百零五场周赛.检查数组是否存在有效划分;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2};
        System.out.println(solution.validPartition(nums));
    }

    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(fundp(nums));
        return fun(nums, 0, dp) == 1;
    }

    private int fun(int[] nums, int start, int[] dp) {
        if (start == nums.length) {
            return 1;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        if (start == nums.length - 1) {
            dp[start] = 0;
            return dp[start];
        }
        if (nums[start] == nums[start + 1]) {
            if (start + 2 < nums.length && nums[start + 2] == nums[start]) {
                dp[start] = Math.max(fun(nums, start + 2, dp), fun(nums, start + 3, dp));
            } else {
                dp[start] = fun(nums, start + 2, dp);
            }
        } else if (nums[start] == nums[start + 1] - 1) {
            if (start + 2 < nums.length && nums[start] == nums[start + 2] - 2) {
                dp[start] = fun(nums, start + 3, dp);
            } else {
                dp[start] = 0;
            }
        } else {
            dp[start] = 0;
        }
        return dp[start];
    }
    private boolean fundp(int[] nums) {
        boolean[] dp = new boolean[nums.length+1];
        dp[0] = true;
        for (int i = 2; i <= nums.length; i++) {
            if (nums[i - 1] == nums[i - 2] && dp[i - 2] ||
                    (i >= 3 && nums[i - 1] == nums[i - 3] && dp[i - 3]) ||
                    (i >= 3 && nums[i - 1] - 2 == nums[i - 3] && dp[i - 3])
            ) {
                dp[i] = true;
            }
        }
        return dp[nums.length];
    }
}