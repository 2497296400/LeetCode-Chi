package 周赛.三百四十一场.第一题;

public class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int x = 0, y = 0;
        for (int i = 0; i < mat.length; i++) {
            int cur = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    cur++;
                }
                if (cur > y) {
                    y = cur;
                    x = i;
                }
            }
        }
        return new int[]{x, y};
    }
}
