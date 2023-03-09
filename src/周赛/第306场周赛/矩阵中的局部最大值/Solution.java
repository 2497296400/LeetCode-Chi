package 周赛.第306场周赛.矩阵中的局部最大值;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int [][]ans=new int[grid.length-2][grid.length-2];
        int n=ans.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=findMax(grid,i,j);
            }
        }
        return ans;
    }

    private int findMax(int[][] grid, int curX, int curY) {
        int max=0;
        for(int i=curX;i<curX+3;i++){
            for(int j=curY;j<curY+3;j++){
                max=Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
