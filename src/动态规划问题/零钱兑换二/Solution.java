package 动态规划问题.零钱兑换二;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, 10, 20};
        int sum = 0;
        System.out.println(change(500, nums));
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
        int[][][] dp = new int[coins.length + 1][amount + 1][46];
        //     int process1 = process1(amount, coins, 0, dp, 45);
        //     System.out.println(dp1(amount, coins));
        System.out.println(process(amount, coins, 0, 45));
        //      System.out.println(Arrays.deepToString(dp));
        return process1(amount, coins, 0, dp, 45);
    }

    private static int process(int amount, int[] coins, int index, int less) {
        if (index == coins.length) {
            return (amount == 0 && less == 0) ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= amount; zhang++) {
            ways += process(amount - zhang * coins[index], coins, index + 1, less - zhang);
        }
        return ways;
    }

    private static int process1(int aim, int[] coins, int index, int[][][] dp, int less) {
        if (less >= 0 && dp[index][aim][less] != 0) {
            return dp[index][aim][less];
        }
        if (index == coins.length) {
            dp[index][aim][less] = (aim == 0 && less == 0) ? 1 : 0;
            return dp[index][aim][less];
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= aim; zhang++) {
            ways += process1(aim - zhang * coins[index], coins, index + 1, dp, less - zhang);
        }
        return dp[index][aim][less];
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

