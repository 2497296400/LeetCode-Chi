package 灵神总结周赛.图论.判断二分图;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0 && !dfs(graph, i, 1, vis)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int color, int[] vis) {
        if (vis[i] != 0) {
            return vis[i] == color;
        }
        vis[i] = color;
        for (int ints : graph[i]) {
            if (!dfs(graph, ints, -color, vis)) {
                return false;
            }
        }
        return true;
    }
}