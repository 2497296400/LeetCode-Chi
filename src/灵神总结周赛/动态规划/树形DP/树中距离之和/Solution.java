package 灵神总结周赛.动态规划.树形DP.树中距离之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer>[] grap;
    int[] asn;
    int[] sz;
    int[] dp;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(6, g)));

    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        asn = new int[n];
        dp = new int[n];
        sz = new int[n];
        grap = new List[n];
        for (int i = 0; i < n; i++) {
            grap[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            grap[u].add(v);
            grap[v].add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return sz;
    }

    private void dfs2(int cur, int pre) {
        asn[cur] = dp[cur];
        for (Integer son : grap[cur]) {
            if (son == pre) {
                continue;
            }
            int dc = dp[cur], ds = dp[son];
            int sc = sz[cur], ss = sz[son];

            dp[cur] -= dp[son] + sz[son];
            sz[cur] -= sz[son];
            dp[son] += dp[cur] + sz[cur];
            sz[son] += sz[cur];
            dfs2(son, cur);
            dp[cur] = dc;
            dp[son] = ds;
            sz[cur] = sc;
            sz[son] = ss;
        }
    }

    private void dfs(int cur, int pre) {
        sz[cur] = 1;
        for (Integer son : grap[cur]) {
            if (son == pre) {
                continue;
            }
            dfs(son, cur);
            dp[cur] += sz[son] + dp[son];
            sz[cur] += sz[son];
        }
    }
}
