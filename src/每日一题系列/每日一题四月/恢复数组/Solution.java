package 每日一题系列.每日一题四月.恢复数组;

import java.util.Arrays;

public class Solution {
    int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415";
        System.out.println(solution.numberOfArrays(s, 823924906));
    }

    public int numberOfArrays(String s, int k) {
        char[] chars = s.toCharArray();
        long[] dp = new long[chars.length + 1];
        Arrays.fill(dp, -1);
        return (int) fun(chars, 0, k, dp);
    }

    private long fun(char[] chars, int index, long k, long[] dp) {
        if (index == chars.length) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        long ans = 0;
        long base = 0;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '0' && base == 0) {
                break;
            }
            base = base * 10 + (chars[i] - '0');
            //System.out.println(base);
            if (base > k) {
                break;
            }
            ans += fun(chars, i + 1, k, dp) % MOD;
        }
        return dp[index] = (ans % MOD);
    }
}
