package 每日一题系列.每日一题十一月.最大加号标志;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] c = {{4,2}};
        System.out.println(solution.orderOfLargestPlusSign(5, c));
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] gird = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(gird[i], 1);
        }
        for (int[] mine : mines) {
            gird[mine[0]][mine[1]] = 0;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (gird[i][j] == 1&&n-j>max) {
                    sum = fun(gird, i, j);
                    max = Math.max(max, sum);
                    System.out.println(i+"   "+j+"    "+ sum);
                }
            }
        }
        return max;
    }

    private int fun(int[][] gird, int i, int j) {
        int curlen = Integer.MAX_VALUE;
        int curX = i;
        int curY = j;
        int curcur = 0;
        while (curX + 1 < gird.length && gird[++curX][curY] != 0) {
            curcur++;
        }
        curlen = Math.min(  curcur++,curlen);
        curX = i;
        curcur=0;
        while (curX - 1 >= 0 && gird[--curX][curY] != 0){
            curcur++;
        }
        curlen = Math.min(curcur, curlen);
        curX = i;
        curcur=0;
        while (curY + 1 < gird.length && gird[curX][++curY] != 0){
            curcur++;
        }
        curlen = Math.min(curlen, curcur);
        curY = j;
        curcur=0;
        while (curY - 1 >= 0 && gird[curX][--curY] != 0){
            curcur++;
        }
        curlen = Math.min(curlen,curcur);
        return curlen + 1;

    }
}
