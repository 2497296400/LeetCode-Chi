package 周赛.三百四十八场.第三题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}};
        System.out.println(solution.matrixSumQueries(3, queries));
    }

    public long matrixSumQueries(int n, int[][] queries) {
        long rowSum = 0L;
        long colSum = 0L;
        int rowIndexSum = 0;
        int colIndexSum = 0;
        long ans = 0L;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        int len = queries.length - 1;
        for (int i = len; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int value = queries[i][2];
            if ((type == 0 && row[index]) || (type == 1 && col[index])) {
                continue;
            }
            if (type == 0) {
                rowSum += value;
                rowIndexSum++;
                row[index] = true;
                ans += (long) (n - colIndexSum) * value ;
            } else {
                colSum += value;
                colIndexSum++;
                col[index] = true;
                ans += (long) (n - rowIndexSum) * value ;
            }
        }
        return ans;
    }
}
