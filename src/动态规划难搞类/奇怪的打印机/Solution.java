package 动态规划难搞类.奇怪的打印机;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaabbb";
        System.out.println(solution.strangePrinter(s));
    }

    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int [][]dp=new int[chars.length][chars.length];
        return fun(chars, 0, chars.length - 1,dp);
    }

    private int fun(char[] chars, int L, int R, int[][] dp) {
        if (L == R) {
            return 1;
        }
        if(dp[L][R]!=0){
            return dp[L][R];
        }
        int ans = R - L + 1;
        for (int curSp = L+1 ; curSp <= R; curSp++) {
            int next = fun(chars, L, curSp-1 , dp) + fun(chars, curSp, R, dp)
                 //如果左边的第一个和右边的第一个相等 减去第一次刷的第一个
             - (chars[L] == chars[curSp] ? 1 : 0);
            ans = Math.min(next, ans);
        }
        dp[L][R]=ans;
        return ans;
    }
}
