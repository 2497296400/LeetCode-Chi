package 动态规划问题.解码方法;

import java.util.Arrays;

public class T {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int []dp=new int[chars.length];
        Arrays.fill(dp, -1);
        return fun(chars, 0,dp);
    }

    private int fun(char[] chars, int index, int[] dp) {
        if (index == chars.length) {
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        if (chars[index] == '0') {
            return 0;
        }
        int sum = fun(chars, index + 1, dp);
        if (index < chars.length - 1 && ((chars[index] - '0') * 10 + (chars[index + 1] - '0')) < 27) {
            sum += fun(chars, index + 2, dp);

        }
        dp[index]=sum;
        return sum;
    }
}
