package 灵神总结周赛.数据结构.矩阵查询可获得的最大分数;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class 离线化加并查集 {
    public static void main(String[] args) {
        int[][] intTow = LeetCodeUtils.getIntTow("[[1,2,3],[2,5,7],[3,5,1]]");
        离线化加并查集 solution = new 离线化加并查集();
        int[] q = LeetCodeUtils.getIntOne("[5,6,2]");
        System.out.println(Arrays.toString(solution.maxPoints(intTow, q)));
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int[] fa, size;

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length, mn = m * n;
        fa = new int[mn];
        size = new int[mn];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        Arrays.fill(size, 1);
        int ql = queries.length;
        int[] asn = new int[ql];
        Integer[] qa = IntStream.range(0, ql).boxed().toArray(Integer[]::new);
        Arrays.sort(qa, Comparator.comparingInt(i -> queries[i]));
        int[][] map = new int[mn][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i * n + j] = new int[]{grid[i][j], i, j};
            }
        }
        Arrays.sort(map, Comparator.comparingInt(i -> i[0]));
        int l = 0;
        for (Integer integer : qa) {
            int query = queries[integer];
            while (map[l][0] < query) {
                int[] ints = map[l];
                int x = ints[1];
                int y = ints[2];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] < query) {
                        merge(x*n+y, nx * n + ny);
                    }
                }
                l++;
            }
            if (grid[0][0] < query) {
                asn[integer] = size[find(0)];
            }
        }
        return asn;
    }

    public int find(int x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    public void merge(int f, int s) {
        f = find(f);
        s = find(s);
        if (f != s) {
            fa[f] = s;
            size[s] += size[f];
        }
    }
}