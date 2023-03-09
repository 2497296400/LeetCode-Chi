package 深度广度遍历问题.矩阵;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int []dx={1,0,0,-1},dy={0,1,-1,0};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.offer(new int []{i,j});
                }
            else {
                mat[i][j]=m+n;
                }
            }
        }
        while(!queue.isEmpty()){
            int []temp=queue.poll();
            for(int i=0;i<4;i++){
                int x=temp[0]+dx[i],y=temp[1]+dy[i];
                if(x>=0&&y>=0&&x<m&&y<n&&mat[x][y]>mat[temp[0]][temp[1]]+1){
                    mat[x][y]=mat[temp[0]][temp[1]]+1;
                    queue.offer(new int []{x,y});
                }
            }
        }
        return mat;
    }
}
