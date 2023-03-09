package 深度广度遍历问题.岛屿面积;

class Solution {
    public int[] dx={1,0,0,-1},dy={0,1,-1,0};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, DFS( grid, i, j));
            }
        }
        return max;
    }
    public int DFS(int [][]grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]!=1)
            return 0;
        grid[x][y]=0;
        int sum=1;
        for(int i=0;i<4;i++){
            int cur_x=dx[i]+x,cur_y=dy[i]+y;
            sum+=DFS(grid,cur_x,cur_y);
        }
        return sum;
    }

}