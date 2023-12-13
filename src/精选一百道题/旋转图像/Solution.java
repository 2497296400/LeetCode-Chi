package 精选一百道题.旋转图像;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int leftx = 0;
        int lefty = 0;
        int rightx = n - 1;
        int righty = n - 1;
        while (leftx < rightx && lefty < righty) {
            process(leftx++, lefty++, rightx--, righty--, matrix);
            }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void process(int leftx, int lefty, int rightx, int righty, int[][] matrix) {
        int n = rightx - leftx;
        for (int i = 0; i <n ; i++) {
            int temp = matrix[leftx][lefty + i];
            matrix[leftx][lefty + i] = matrix[rightx - i][lefty];
            matrix[rightx - i][lefty] = matrix[rightx][righty - i];
            matrix[rightx][rightx - i] = matrix[leftx + i][righty];
            matrix[leftx + i][righty] = temp;
        }
    }
}
