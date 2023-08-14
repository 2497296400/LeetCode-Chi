package 基础数据结构.图的类型;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// no negative weight
public class Code06_Dijkstra {
    public static void main(String[] args) {
        int[][] g = new int[][]{
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 1},
                {1, 3, 1},
                {2, 3, 2},
                {2, 4, 1},
                {3, 4, 1},
                {3, 5, 1},
                {4, 5, 2},
                {4, 6, 1},
                {5, 6, 2},
        };
        System.out.println(new Code06_Dijkstra().d(g, 3, 8));
    }

    public int d(int[][] g, int start, int end) {
        int[] weight = new int[g.length];
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
        boolean[] vis = new boolean[g.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int f = poll[0];
            vis[f] = true;
            int v = poll[1];
            if (f == end) {
                return v;
            }
            for (int[] ints : list[f]) {
                int s = ints[0];
                int w = ints[1];
                if (vis[s])
                    continue;
                pq.add(new int[]{s, v + w});
            }
        }
        return -1;
    }
}
