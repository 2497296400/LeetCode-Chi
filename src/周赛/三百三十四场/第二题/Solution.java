package 周赛.三百三十四场.第二题;

import java.util.HashMap;

public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] sumM = new int[m];
        int[] sumN = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            int x = ints[0];
            int y = ints[1];
            if (++sumM[x] == n) {
                return i;
            }
            if (++sumN[y] == m) {
                return i;
            }
        }
        return 0;
    }
}
