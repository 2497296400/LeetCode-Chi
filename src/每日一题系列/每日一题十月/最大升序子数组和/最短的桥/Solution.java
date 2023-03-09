package 每日一题系列.每日一题十月.最大升序子数组和.最短的桥;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    int maxX;
    int maxY;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        System.out.println(solution.shortestBridge(g));
    }

    public int shortestBridge(int[][] grid) {
        Set<Data> f = new HashSet<>();
        Set<Data> s = new HashSet<>();
        boolean flag = true;
        maxX = grid.length;
        maxY = grid[0].length;
        int ans =Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (flag && grid[i][j] == 1) {
                    flag = false;
                    fun(grid, i, j, f);
                } else if (grid[i][j] == 1) {
                    for (Data data1 : f) {
                        ans = Math.min(ans, Math.abs(data1.x - i) + Math.abs(data1.y - j));
                    }
                }
            }
        }
        return ans - 1;
    }
    private void fun(int[][] grid, int i, int j, Set<Data> f) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
            return;
        }
        f.add(new Data(i, j));
        grid[i][j] = 0;
        fun(grid, i + 1, j, f);
        fun(grid, i - 1, j, f);
        fun(grid, i, j + 1, f);
        fun(grid, i, j - 1, f);
    }
}

class Data {
    int x;
    int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (x != data.x) return false;
        return y == data.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
