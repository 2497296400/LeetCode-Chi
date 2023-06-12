package 周赛.三百四十七场.对角线上不同值的数量差;

import java.util.HashSet;

public class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans[i][j] = getAns(i, j, grid);
            }
        }
        return ans;
    }

    private int getAns(int i, int j, int[][] grid) {
        int pre = getPre(i - 1, j - 1, grid);
        int next = getNext(i + 1, j + 1, grid);
        return Math.abs(pre - next);
    }

    private int getNext(int i, int j, int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        while (i < grid.length && j < grid[0].length) {
            set.add(grid[i++][j++]);
        }
        return set.size();
    }

    private int getPre(int i, int j, int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        while (i >= 0 && j >= 0) {
            set.add(grid[i--][j--]);
        }
        return set.size();
    }
}
