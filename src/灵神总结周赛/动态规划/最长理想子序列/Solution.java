package 灵神总结周赛.动态规划.最长理想子序列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestIdealString("abcd", 3));
    }

    /**
     * @author chi
     * @param s 
     * @param k
     * @return 
     */
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int curIndex = aChar - 'a';
            for (int i = Math.max(0, curIndex - k); i <= Math.min(curIndex + k, 25); i++) {
                dp[curIndex] = Math.max(dp[curIndex],dp[i]);
            }
            dp[curIndex]++;
        }
        return Arrays.stream(dp).max().getAsInt();
        
        
  /*      int ans = 0;
        Integer[][] dp = new Integer[s.length()][26];
        HashSet<Character> set = new HashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                ans = Math.max(ans, fun(chars, i, chars[i], k, dp));
            }
        }
        return ans;*/
    }
    
    private int fun(char[] chars, int index, char pre, int k, Integer[][] dp) {
        if (index < 0) {
            return 0;
        }
        int max = 0;
        if (Math.abs(chars[index] - pre) <= k) {
            max = Math.max(fun(chars, index - 1, chars[index], k, dp) + 1, fun(chars, index - 1, pre, k, dp));
        } else {
            max = Math.max(max, fun(chars, index - 1, pre, k, dp));
        }
        return dp[index][pre - 'a'] = max;
    }
}
