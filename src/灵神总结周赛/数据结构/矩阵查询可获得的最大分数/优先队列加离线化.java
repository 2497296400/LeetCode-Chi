package 灵神总结周赛.数据结构.矩阵查询可获得的最大分数;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class 优先队列加离线化 {
    public static void main(String[] args) {
        int[][] intTow = LeetCodeUtils.getIntTow("[[1,2,3],[2,5,7],[3,5,1]]");
        优先队列加离线化 solution = new 优先队列加离线化();
        int[] q = LeetCodeUtils.getIntOne("[5,6,2]");
        System.out.println(Arrays.toString(solution.maxPoints(intTow, q)));
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
        int cSum = 0;

        int l = 0;
        int m = grid.length, n = grid[0].length;
        pq.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = 0;
        int ql = queries.length;
        int[] ans = new int[ql];
        Integer[] quer = IntStream.range(0, ql).boxed().toArray(Integer[]::new);
        Arrays.sort(quer, Comparator.comparingInt(k -> queries[k]));
        for (Integer integer : quer) {
            int q = queries[integer];
            while (!pq.isEmpty() && pq.peek()[0] < q) {
                cSum++;
                int[] ints = pq.poll();
                int x = ints[1];
                int y = ints[2];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx >= 0 && ny >= 0 && ny < m && nx < n && grid[nx][ny] != 0) {
                        pq.add(new int[]{grid[nx][ny], nx, ny});
                        grid[nx][ny] = 0;
                    }
                }
            }
            ans[integer] = cSum;
        }
        return ans;
    }
}
