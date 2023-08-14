package 基础数据结构.图的类型;

import java.util.*;

public class Code04_Kruskal {
    public static void main(String[] args) {
        int[][] g = new int[][]{
                {1, 2, 3},
                {1, 3, 4},
                {2, 3, 5},
                {2, 4, 6},
                {3, 4, 7},
                {3, 5, 8},
                {4, 5, 9},
                {4, 6, 10},
                {5, 6, 11},
                {5, 7, 12},
                {6, 7, 13},
                {6, 8, 14},
                {7, 8, 15},
                {7, 9, 16},
                {8, 9, 17},
                {8, 10, 18},
                {9, 10, 19},
                {9, 11, 20},
                {10, 11, 21},
                {10, 12, 22},
                {11, 12, 23},
                {11, 13, 24},
                {12, 13, 25},
                {12, 14, 26},
                {13, 14, 27},
                {13, 15, 28},
                {14, 15, 29},
                {14, 16, 30},
                {15, 16, 31},
                {15, 17, 32},
                {16, 17, 33},
                {16, 18, 34},
                {17, 18, 35},
                {17, 19, 36},
                {18, 19, 37},
                {18, 20, 38},
                {19, 20, 39},
                {19, 21, 40},
                {20, 21, 41},
                {20, 22, 42},
                {21, 22, 43},
                {21, 23, 44},
                {22, 23, 45},
                {22, 24, 46},
                {23, 24, 47},
                {23, 25, 48},
                {24, 25, 49},
                {24, 26, 50},
                {25, 26, 0},

        };
        System.out.println(Arrays.toString(new Code04_Kruskal().k(g)));
        
    }

    public int[] k(int[][] g) {
        List<int[]>[] list = new List[g.length];
        for (int i = 0; i < g.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < g.length; i++) {
            int f = g[i][0];
            int s = g[i][1];
            int v = g[i][2];
            list[f].add(new int[]{s, v});
            list[s].add(new int[]{f, v});
        }
        fa = new int[g.length + 1];
        for (int i = 1; i < fa.length; i++) {
            fa[i] = i;
        }
        int[] res = new int[g.length];
        boolean[] vis = new boolean[g.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.addAll(Arrays.asList(g));
        int len = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int f = poll[0];
            int s = poll[1];
            if (find(f) == find(s)) {
                continue;
            }
            union(f, s);
            if (!vis[f]) {
                res[len++] = f;
            }
            if (!vis[s]) {
                res[len++] = s;
            }
            vis[f] = true;
            vis[s] = true;
        }
        return res;
    }

    private int[] fa;

    public int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    private void union(int i, int j) {
        fa[find(i)] = find(j);
    }
}