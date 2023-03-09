package 动态规划难搞类.移除盒子;

public class Solution {
    //神奇的猜法
    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return f(boxes, 0, boxes.length - 1, 0, dp);
    }

    private int f(int[] boxes, int l, int r, int k, int[][][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }

        //根据（l，r)范围上前边跟着相同的
        int ans = f(boxes, l + 1, r, 0, dp) + (k + 1) * (k + 1);
        for (int i = l + 1; i <= r; i++) {
            if (boxes[i] == boxes[l]) {
                ans = Math.max(ans, f(boxes, l + 1, i - 1, 0, dp) + f(boxes, i, r, k + 1, dp));
            }
        }
        dp[l][r][k]=ans;
        return ans;
    }
}
