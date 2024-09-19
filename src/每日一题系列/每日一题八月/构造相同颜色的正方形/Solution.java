package 每日一题系列.每日一题八月.构造相同颜色的正方形;

public class Solution {
    public boolean canMakeSquare(char[][] grid) {
        boolean ans = false;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                if (check(i, j, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int i, int j, char[][] grid) {
        int sum = 0;
        if (grid[i + 1][j] == grid[i][j]) {
            sum++;
        }
        if (grid[i][j + 1] == grid[i][j]) {
            sum++;
        }
        if (grid[i + 1][j + 1] == grid[i][j]) {
            sum++;
        }
        return sum >= 2 || sum==0;
    }
}
