package 每日一题系列.每日一题十二月.堆叠长方体的最大高度;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxHeight(new int[][]{{50,45,20},{95,37,53},{45,23,12}}));
    }

    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int i = 0; i < cuboids.length; i++) {
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, (o1, o2) ->(o1[0]+o1[1]+o1[2])-(o2[0]+o2[1]+o2[2]));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fun(cuboids, -1, 0, dp);
    }

    private int fun(int[][] cuboids, int top, int curIndex, int[] dp) {
        if (curIndex == cuboids.length) {
            return 0;
        }
        if (top != -1 && dp[top] != -1) {
            return dp[top];
        }
        int height = fun(cuboids, top, curIndex + 1, dp);

        if (top == -1 || (cuboids[top][0] <= cuboids[curIndex][0] && cuboids[top][1] <= cuboids[curIndex][1] && cuboids[top][2] <= cuboids[curIndex][2])) {
            height = Math.max(height, fun(cuboids, curIndex, curIndex + 1, dp)+cuboids[curIndex][2]);
        }
        if (top != -1) {
            dp[top] = height;
        }
        return height;
    }

}