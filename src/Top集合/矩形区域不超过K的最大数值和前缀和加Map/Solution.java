package Top集合.矩形区域不超过K的最大数值和前缀和加Map;

import java.util.TreeSet;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix[0].length > matrix.length) {
            matrix = reversal(matrix);
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            int rowSum = 0;
            int[] colSum = new int[col];
            for (int r = i; r < row; r++) {
                TreeSet<Integer> treeMap = new TreeSet<>();
                treeMap.add(0);
                for (int c = 0; c < col; c++) {
                    colSum[c] += matrix[r][c];
                    rowSum += colSum[c];
                    Integer curAns = treeMap.ceiling(rowSum - k);
                    if (curAns != null) {
                        ans = Math.max(ans, curAns);
                    }
                    treeMap.add(rowSum);
                }
            }
        }
        return ans;
    }

    private int[][] reversal(int[][] matrix) {
        int[][] r = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                r[i][j] = matrix[j][i];
            }
        }
        return r;
    }
}
