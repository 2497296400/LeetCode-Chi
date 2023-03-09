package 回文字符串系列.不重叠回文子字符串的最大数目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "kwnwkekokedadq";
        String c = "abaccdbbd";
        System.out.println(solution.maxPalindromes(c, 3));
    }

    public int maxPalindromes(String s, int k) {
        char[] chars = s.toCharArray();
        List<Data> data = new ArrayList<>();
        boolean[][] isP = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() - 1; i++) {
            isP[i][i] = true;
            isP[i][i + 1] = chars[i] == chars[i + 1];
        }
        isP[chars.length - 1][chars.length - 1] = true;
        for (int i = chars.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < chars.length; j++) {
                isP[i][j] = chars[i] == chars[j] && isP[i + 1][j - 1];
            }
        }
        for (int start = chars.length - 3; start >= 0; start--) {
            for (int end = start + 2; end < chars.length; end++) {
                isP[start][end] = chars[start] == chars[end] && isP[start + 1][end - 1];
            }
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + k - 1; j < chars.length; j++) {
                if (isP[i][j]) {
                    data.add(new Data(i, j - i + 1));
                    break;
                }
            }
        }
        int[][] dp = new int[2005][2005];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return curFun(data, 0, 0, dp);
    }

    private int curFun(List<Data> data, int strat, int end, int[][] dp) {
        if (strat >= data.size()) {
            return 0;
        }
        if (dp[strat][end] != -1) {
            return dp[strat][end];
        }
        int p1;
        p1 = curFun(data, strat + 1, end, dp);
        if (data.get(strat).curIndex >= end) {
            p1 = Math.max(p1, 1 + curFun(data, strat + 1, data.get(strat).minS + data.get(strat).curIndex, dp));
        }
        dp[strat][end] = p1;
        return p1;
    }

    public int maxPa(String s, int k) {
        int[] dp = new int[s.length() + 1];
        int n = s.length();
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = l + i % 2;
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    dp[r + 1] = Math.max(dp[l] + 1, dp[r + 1]);
                }
                l--;
                r++;
            }
        }
        return dp[s.length()];
    }
}

class Data {
    int curIndex;
    int minS;

    public Data(int curIndex, int minS) {
        this.curIndex = curIndex;
        this.minS = minS;
    }
}