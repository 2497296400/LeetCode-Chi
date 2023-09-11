package 每日一题系列.每日一题四月.多边形三角剖分的最低得分;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 1, 4, 1, 5};
        System.out.println(Math.pow(2, 16));
        System.out.println(solution.minScoreTriangulation(arr));
    }

    public int minScoreTriangulation(int[] values) {
        Integer dp[][] = new Integer[values.length][values.length];
        return fun(values, 1, values.length - 1, dp);
    }

    private int fun(int[] values, int l, int r, Integer[][] dp) {
        if (l == r) {
            return 0;
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            ans = Math.min(ans, values[l-1] * values[i] * values[r] + fun(values, l, i, dp) + fun(values, i+1, r, dp));
        }
        dp[l][r] = ans;
        return ans;
    }
}
