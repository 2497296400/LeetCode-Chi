package 动态规划问题.o1背包问题;

public class SOlution {
    public static void main(String[] args) {
        String[] str = {"10", "0001", "110001001", "1", "0"};
        System.out.println(findMaxForm(str, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int Sum0 = 0;
        int Sum1 = 0;
        for (String str : strs) {
            for (char cha : str.toCharArray()) {
                if (cha == '0') {
                    Sum0++;
                } else {
                    Sum1++;
                }
            }
            for (int i = m; i >= Sum0; i--) {
                for (int j = n; j >= Sum1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - Sum0][j - Sum1] + 1);
                }
            }
            Sum0 = 0;
            Sum1 = 0;
        }
        return dp[m][n];
    }
}
