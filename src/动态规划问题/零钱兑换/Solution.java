package 动态规划问题.零钱兑换;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(minCoins1(nums, 11));
    }

    public static int minCoins1(int[] nums, int aim) {
        int[][] dp = new int[nums.length + 1][aim + 1];
        if (nums.length == 0 || aim <= 0) {
            return -1;
        }
        int sum = process(nums, aim, 0, dp,0);
        for (int i = 1; i <= aim; i++) {
            dp[nums.length][i] = -1;
        }
        int sum2 = process2(nums, aim, 0, dp);
        return sum;
    }

    private static int process2(int[] nums, int aim, int temp, int[][] dp) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -1;
                if (dp[i + 1][j] != -1) {
                    dp[i][j] = dp[i + 1][j];
                }
                if (j - nums[i] >= 0 && dp[i][j - nums[i]] != -1) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = dp[i][j - nums[i]] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - nums[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
    private static int process(int[] nums, int aim, int temp, int[][] dp,int strat) {
        if (aim == 0) {
            return 0;
        }
        if (aim < 0) {
            return -1;
        }
        if (dp[temp][aim] != 0) {
            return dp[temp][aim];
        }
        int min = Integer.MAX_VALUE;
        for (int i = strat; i < nums.length; i++) {
            int res = process(nums, aim - nums[i], i, dp,i);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        dp[temp][aim] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[temp][aim];
    }
}
