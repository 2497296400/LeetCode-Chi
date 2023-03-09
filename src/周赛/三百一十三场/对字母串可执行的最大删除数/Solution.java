package 周赛.三百一十三场.对字母串可执行的最大删除数;

import java.util.Arrays;

public class Solution {
    public int max = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "wwwwwwww";
        System.out.println(solution.deleteString(s));
    }

    public int deleteString(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
         fun(s, 0, dp);
        System.out.println(Arrays.toString(dp));
        return  0;

    }

    private int fun(String s, int index, int[] dp) {
        if (s.length() == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans = 0;
        for (int cur = 1; cur <= s.length() / 2; ) {
            String first = s.substring(0, cur);
            String seocnd = s.substring(cur, 2 * cur);
            if (first.equals(seocnd)) {
                ans = Math.max(ans, fun(s.substring(cur), cur + index, dp) + 1);
                cur += cur;
            } else {
                cur++;
            }
        }
        dp[index] = ans;
        return ans;
    }
}