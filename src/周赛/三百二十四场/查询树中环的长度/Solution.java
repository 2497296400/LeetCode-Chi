package 周赛.三百二十四场.查询树中环的长度;

public class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int res = 1;
            int a = queries[i][0];
            int b = queries[i][1];
            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                res++;
            }
            ans[i] = res;
        }
        return ans;
    }
}
