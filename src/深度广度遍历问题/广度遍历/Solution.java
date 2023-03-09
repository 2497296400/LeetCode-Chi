package 深度广度遍历问题.广度遍历;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int currcolor = image[sr][sc];
        if (currcolor == newcolor) {
            return image;
        }
        int n=image.length,m=image[0].length;
        Queue<int []>queue= new LinkedList<>();
        queue.add(new int[]{sr,sc});
        image[sr][sc]=newcolor;
        while (!queue.isEmpty()){
            int []cell= queue.poll();
            int x=cell[0],y=cell[1];
            for (int i=0;i<4;i++){
                int mx=x+dx[i],my=y+dy[i];
                if(mx>=0&&mx<n&&my>=0&&my<m&&image[mx][my]==currcolor){
                    queue.add(new int[]{mx,my});
                    image[mx][my]=newcolor;
                }
            }
        }
        return image;
    }
}
