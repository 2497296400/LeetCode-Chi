package 灵神总结周赛.图论.判断二分图;

public class 并查集做法 {
    int[] fa;

    public boolean isBipartite(int[][] graph) {
        fa = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            int[] g = graph[i];
            for (int next : g) {
                if (find(next) == find(i)) {
                    return false;
                }
                fa[find(g[0])] = find(next);
            }
        }
        return true;
    }

    public int find(int x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
