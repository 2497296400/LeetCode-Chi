package 周赛.三百零五场周赛.检查数组是否存在有效划分;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        Test test = new Test();
        System.out.println(test.validPartition(nums));
    }

    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return fun(nums, 0, nums.length, dp) == 1;
    }

    private int fun(int[] nums, int curIndex, int length, int[] dp) {
        if (curIndex == length) {
            return 1;
        }
        if (curIndex == length - 1) {
            dp[curIndex] = 0;
            return dp[curIndex];
        }
        if (dp[curIndex] != -1) {
            return dp[curIndex];
        }
        if (nums[curIndex] == nums[curIndex + 1]) {
            if (curIndex + 2 < length) {
                if (nums[curIndex] == nums[curIndex + 2]) {
                    int curFist = fun(nums, curIndex + 2, length, dp);
                    int curNext = fun(nums, curIndex + 3, length, dp);
                    dp[curIndex] = Math.max(curFist, curNext);
                } else {
                    dp[curIndex] = fun(nums, curIndex + 2, length, dp);
                }
            }
        } else if (nums[curIndex] == nums[curIndex + 1] - 1) {
            if (curIndex + 2 < length && nums[curIndex] == nums[curIndex + 2] - 2) {
                dp[curIndex] = fun(nums, curIndex + 3, length, dp);
            }else {
                dp[curIndex]=0;
            }
        }
        return dp[curIndex];
    }
}
