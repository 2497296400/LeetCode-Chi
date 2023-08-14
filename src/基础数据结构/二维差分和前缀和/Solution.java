package 基础数据结构.二维差分和前缀和;

public class Solution {
    /* 二维差分
     *  +1     -1
     *  -1     +1
     *
     * */
    public int getPre(int[][] gird) {
        //二维前缀和
        int[][] preMax = new int[gird.length + 1][gird[0].length + 1];
        for (int i = 1; i < gird.length; i++) {
            for (int j = 1; j < gird.length; j++) {
                preMax[i + 1][j + 1] = preMax[i + 1][j] + preMax[i][j + 1] - preMax[i][j] + gird[i][j];
            }
        }
        return 0;
    }
}
