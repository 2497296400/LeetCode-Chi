package 灵神总结周赛.数据结构.好路径的数目;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    int[] fa, size;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr={1,1,2,2,3};
        int[][] g = LeetCodeUtils.getIntTow("[[0,1],[1,2],[2,3],[2,4]]");
        System.out.println(solution.numberOfGoodPaths(arr, g));
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        List<Integer>[] g = new List[vals.length];

        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int f = edge[0];
            int s = edge[1];
            g[f].add(s);
            g[s].add(f);
        }
        int n = vals.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        size = new int[n];
        
        Integer[] array = IntStream.range(0, n).boxed().sorted((i, j) -> vals[i] - vals[j]).toArray(Integer[]::new);
        Arrays.fill(size, 1);
        int asn = 0;
        for (Integer x : array) {
            int vx = vals[x];
            int fx = find(x);
            for (Integer y : g[x]) {
                y = find(y);
                if (fx == y || vals[y] > vx) {
                    continue;
                }
                if (vals[y] == vx) {
                    asn += size[fx] * size[y];
                    size[fx] += size[y];
                }
                fa[y] = fx;
            }
        }
        return asn+n;
    }

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
