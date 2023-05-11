package 每日一题系列.每日一题四月.分隔数组以得到最大和;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        System.out.println(solution.maxSumAfterPartitioning(arr, 4));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp = new Integer[arr.length];
        return fun(arr, 0, k, dp);
    }

    private int fun(int[] arr, int index, int k, Integer[] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        int curMax = 0;
        int ans = 0;
        for (int i = index; i < Math.min(index + k, arr.length); i++) {
            curMax = Math.max(curMax, arr[i]);
            ans = Math.max(ans, fun(arr, i + 1, k, dp) + curMax * (i - index + 1));
        }
        dp[index] = ans;
        return ans;
    }
}
