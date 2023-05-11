package 动态规划问题.零钱兑换二;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,1};
        int sum = 0;
        System.out.println(change(6, nums));
    }

    public static int change(int amount, int[] coins) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                dp[j] = dp[j] + dp[j - coins[i]];
//            }
//        }
//        Arrays.fill(dp, -1);
        int[][] dp = new int[coins.length + 1][amount + 1];
        int process1 = process1(amount, coins, 0, dp);
        System.out.println(dp1(amount, coins));
        System.out.println(process1);
        System.out.println(Arrays.deepToString(dp));
        return 1;
    }

    private static int process(int amount, int[] coins, int index) {
        if (index == coins.length) {
            return amount == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= amount; zhang++) {
            ways += process(amount - zhang * coins[index], coins, index + 1);
        }
        return ways;
    }

    private static int process1(int aim, int[] coins, int index, int[][] dp) {
        if (dp[index][aim] != 0) {
            return dp[index][aim];
        }
        if (index == coins.length) {
            dp[index][aim] = aim == 0 ? 1 : 0;
            return dp[index][aim];
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= aim; zhang++) {
            ways += process1(aim - zhang * coins[index], coins, index + 1, dp);
        }
        dp[index][aim] = ways;
        return dp[index][aim];
    }

    private static int dp1(int aim, int[] coins) {
        int[][] dp = new int[coins.length + 1][aim + 1];
        dp[coins.length][0] = 1;
        for (int index = coins.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
//                for (int zhang = 0; zhang * coins[index] <= rest; zhang++) {
//                    dp[index][rest] += dp[index + 1][rest - zhang * coins[index]];
//                }
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) {
                    dp[index][rest] += dp[index][rest - coins[index]];
                }
            }
        }
        return dp[0][aim];

    }
}

