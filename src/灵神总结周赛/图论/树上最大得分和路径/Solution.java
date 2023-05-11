package 灵神总结周赛.图论.树上最大得分和路径;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int[] bobTime;

    public static void main(String[] args) {
        int[][] g = LeetCodeUtils.getIntTow("[[0,1],[1,2],[1,3],[3,4]]");
        Solution solution = new Solution();
        System.out.println(solution.mostProfitablePath(g, 3, new int[]{-2, 4, 2, -4, 6}));
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length;
        List<Integer>[] g = new List[n + 1];
        bobTime = new int[n + 1];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        Arrays.setAll(g, ArrayList<Integer>::new);
        for (int[] edge : edges) {
            int f = edge[0];
            int s = edge[1];
            g[f].add(s);
            g[s].add(f);
        }
        dfsbob(bob, -1, 0, g);
        g[0].add(-1);
        dfsAlica(0, -1, 0, 0, amount, bobTime, g);
        return ans;
    }

    int ans = Integer.MIN_VALUE;

    private void dfsAlica(int c, int fa, int t, int value, int[] amount, int[] bobTime, List<Integer>[] g) {
        if (t < bobTime[c]) {
            value += amount[c];
        } else if (t == bobTime[c]) {
            value += amount[c] / 2;
        }
        //System.out.println(c+" " + value);
        if (g[c].size() == 1) {
            //System.out.println(c);
            ans = Math.max(ans, value);
            return;
        }
        for (Integer next : g[c]) {
            if (next != fa) {
                dfsAlica(next, c, t + 1, value, amount, bobTime, g);
            }
        }
    }

    private boolean dfsbob(int c, int fa, int t, List<Integer>[] g) {
        if (c == 0) {
            bobTime[c] = t;
            return true;
        }
        for (int i : g[c]) {
            if (i != fa && dfsbob(i, c, t + 1, g)) {
                bobTime[c] = t;
                return true;
            }
        }
        
        return false;
    }
}
