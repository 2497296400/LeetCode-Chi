package 周赛.三百二十九场.第二题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }
}
