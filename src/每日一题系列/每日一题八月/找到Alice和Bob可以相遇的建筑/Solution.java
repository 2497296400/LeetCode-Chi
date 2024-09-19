package 每日一题系列.每日一题八月.找到Alice和Bob可以相遇的建筑;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {6,4,8,5,2,7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4},{2,2}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries(heights, queries)));
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        List<int[]>[] ps = new List[heights.length];
        Arrays.setAll(ps, i->new ArrayList<>());
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
                continue;
            }
            ps[b].add(new int[]{heights[a], i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < heights.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                ans[pq.poll()[1]] = i;
            }
            for (int[] p : ps[i]) {
                pq.add(p);
            }
        }
        return ans;
    }
}