package 压缩DP.连通两组点的最小成本;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> cost;
    private int[] minCost;
    private int[][] memo;

    public int connectTwoGroups(List<List<Integer>> cost) {
        this.cost = cost;
        int m = cost.size(), n = cost.get(0).size();
        minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        memo = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minCost[j] = Math.min(minCost[j], cost.get(i).get(j));
            }
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= cost.size()) {
            int res = 0;
            for (int k = 0; k < minCost.length; k++) {
                if ((j & (1 << k)) == 0) {
                    res += minCost[k];
                }
            }
            return res;
        }
        int res = Integer.MAX_VALUE;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        for (int k = 0; k < cost.get(0).size(); k++) {
            res = Math.min(res, cost.get(i).get(k) + dfs(i + 1, j | (1 << k)));
        }
        return memo[i][j] = res;
        
    }
}
