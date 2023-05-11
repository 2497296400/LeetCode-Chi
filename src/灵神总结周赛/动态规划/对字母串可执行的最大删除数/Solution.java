package 灵神总结周赛.动态规划.对字母串可执行的最大删除数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteString("aaabaab"));
    }

    public int deleteString(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return fun(s, 0, dp) + 1;
    }

    private int fun(String s, int strat, int[] dp) {
        if (strat == s.length()) {
            return 0;
        }
        if (dp[strat] != -1) {
            return dp[strat];
        }
        int ans = 0;
        for (int i = strat; i < (s.length() + strat) / 2; ) {
            String f = s.substring(strat, i + 1);
            String e = s.substring(i + 1, i + 1 + f.length());
            if (f.equals(e)) {
                ans = Math.max(ans, fun(s, i + 1, dp) + 1);
                //优化点
                i += f.length();
            } else {
                i++;
            }
        }
        return dp[strat] = ans;
    }
}
