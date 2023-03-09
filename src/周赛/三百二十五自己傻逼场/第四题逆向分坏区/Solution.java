package 周赛.三百二十五自己傻逼场.第四题逆向分坏区;

public class Solution {
    final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4};
        System.out.println(solution.countPartitions(arr, 4));
    }

    public int countPartitions(int[] nums, int k) {
        long curSum = 0;
        for (int num : nums) {
            curSum += num;
        }
        if (curSum < 2 * k) {
            return 0;
        }
        Long[][] dp = new Long[nums.length][k + 1];
        long ways = getM(2, nums.length)%MOD;
        long cur = fun(nums, 0, k, dp);
        return (int) ((ways - 2 * cur)%MOD+MOD)%MOD;

    }

    private long fun(int[] nums, int index, int k, Long[][] dp) {
        if (index == nums.length) {
            return k > 0 ? 1 : 0;
        }
        if (k < 0) {
            return 0;
        }
        if (dp[index][k] != null) {
            return dp[index][k];
        }
        long ways = 0;
        ways += fun(nums, index + 1, k - nums[index], dp);
        ways += fun(nums, index + 1, k, dp);
        dp[index][k] = ways;
        return ways;
    }

    private long getM(int f, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 != 0) {
            return f * getM(f, n - 1) % MOD;
        } else {
            long cur = getM(f, n / 2) % MOD;
            return (cur * cur) % MOD;
        }
    }
}
