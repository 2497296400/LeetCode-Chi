package 每日一题系列.每日一题四月.合并石头的最低成本;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 4, 1};
        System.out.println(solution.mergeStones(arr, 2));
    }

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((stones.length - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] preSum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        Integer[][][] dp = new Integer[stones.length][stones.length][k + 1];
        return fun(0, stones.length - 1, k, 1, preSum, dp);
    }

    private int fun(int l, int r, int k, int p, int[] preSum, Integer[][][] dp) {
        if (dp[l][r][p] != null) {
            return dp[l][r][p];
        }
        if (l == r) {
            return p == 1 ? 0 : -1;
        }
        if (p == 1) {
            int next = fun(l, r, k, k, preSum, dp);
            if (next == -1) {
                return dp[l][r][p] = -1;
            } else {
                return dp[l][r][p] = next + preSum[r + 1] - preSum[l];
            }
        } else {
            int curMin = Integer.MAX_VALUE;
            for (int cur = l; cur < r; cur ++) {
                int left = fun(l, cur, k, 1, preSum, dp);
                int right = fun(cur + 1, r, k, p - 1, preSum, dp);
                if (left == -1 || right == -1) {
                    return -1;
                }
                curMin = Math.min(curMin, left + right);
            }
            return dp[l][r][p] = curMin;
        }
    }
}
