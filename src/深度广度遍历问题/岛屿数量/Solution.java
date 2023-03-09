package 深度广度遍历问题.岛屿数量;

class Solution {
    public int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        char[][] gird = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int i = new Solution().numIslands(gird);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max +=1;
                    DFS(grid, i, j);
                }
            }
        }
        return max;
    }

    private int DFS(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length || y > grid[0].length || grid[x][y] != 1) {
            return 0;
        } else {
            grid[x][y] =0;
            for (int i = 0; i < 4; i++) {
                int cur_x = dx[i] + x;
                int cur_y = dy[i] + y;
                DFS(grid, cur_x, cur_y);
            }
            return 1;
        }
    }
}



