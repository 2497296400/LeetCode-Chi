package 动态规划问题.一和零;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"10", "0001", "111001", "1", "0"};

        System.out.println(solution.findMaxForm(strings, 5, 3));

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= strs.length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(strs, m, n, 0,dp);
    }

    private int fun(String[] strs, int m, int n, int start, int[][][] dp) {
        if (m < 0 || n < 0) {
            return -1;
        }
        if (m == 0 && n == 0||start==strs.length) {
            return 0;
        }
        if(dp[m][n][start]!=-1){
            return dp[m][n][start];
        }
        int curMax = 0;
        int[] cur = get(strs[start]);
        int p1 = fun(strs, m - cur[0], n - cur[1], start+1, dp);
        int p2 = fun(strs, m, n, start+1, dp);
        curMax = Math.max(curMax, Math.max(p2, p1 + 1));
        dp[m][n][start]=curMax;
        return curMax;
    }

    private int[] get(String str) {
        int[] asn = new int[2];
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar == '0') {
                asn[0]++;
            } else {
                asn[1]++;
            }
        }
        return asn;
    }
}
