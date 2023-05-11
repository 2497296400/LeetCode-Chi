package 每日一题系列.每日一题四月.最长等差数列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestArithSeqLength(new int[]{24, 13, 1, 100, 0, 94, 3, 0, 3}));

    }

    private Map<Integer, Integer>[] maxLen;
    private int[] a;
    private int ans;

    public int longestArithSeqLength(int[] nums) {
        a = nums;
        int n = nums.length;
        maxLen = new Map[n];
        for (int i = 1; i < n; i++) {
            dfs(i);
        }
        return ans;
    }

    private Map<Integer, Integer> dfs(int i) {
        if (maxLen[i] != null) {
            return maxLen[i];
        }
        maxLen[i] = new HashMap<>();
        for (int j = i - 1; j >= 0; j--) {
            int d = a[i] - a[j];
            if (!maxLen[i].containsKey(d)) {
                maxLen[i].put(d, dfs(j).getOrDefault(d, 1) + 1);
                ans = Math.max(ans, maxLen[i].get(d));
            }
        }
        return maxLen[i];
    }
}
