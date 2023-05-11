package 灵神总结周赛.图论.查询树中环的长度;

public class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int len = 0;
        for (int[] query : queries) {
            int cur = 0;
            int f = query[0];
            int s = query[1];
            while (f != s) {
                if (f > s) {
                    f = f / 2;
                } else {
                    s = s / 2;
                }
                cur++;
            }
            ans[len++] = cur;
        }
        return ans;
    }
}
