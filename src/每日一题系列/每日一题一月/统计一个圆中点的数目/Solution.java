package 每日一题系列.每日一题一月.统计一个圆中点的数目;

public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int len = 0;
        for (int[] query : queries) {
            int curSum = 0;
            for (int[] point : points) {
                if (InCircle(query, point)) {
                    curSum++;
                }
                ans[len++] = curSum;
            }
        }
        return ans;
    }

    private boolean InCircle(int[] queries, int[] point) {
        return Math.sqrt(Math.pow(queries[0] - point[0], 2) + Math.pow(queries[1] - point[1], 2)) <= queries[2];
    }
}
