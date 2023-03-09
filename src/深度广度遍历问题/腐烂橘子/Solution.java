package 深度广度遍历问题.腐烂橘子;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] x = {1, 0, 0, -1}, y = {0, 1, -1, 0};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int flag1=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    flag1=1;
                }
//                if (grid[i][j] == 1) {
//                    int flag = 0;
//                    for (int temp = 0; temp < 4; temp++) {
//                        int tx = x[temp] + i, ty = y[temp] + j;
//                        if (tx >= 0 && ty >= 0 && tx < m && ty < n && grid[tx][ty] != 0) {
//                            flag = 1;
//                        }
//                    }
//                    if (flag == 0||flag1==0) {
//                        return -1;
//                    }
//                }
            }
        }
        Queue<int []>queue1=new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = temp[0] + x[i], dy = temp[1] + y[i];
                if (dx >= 0 && dy >= 0 && dx < m && dy < n && grid[dx][dy] == 1) {
                    grid[dx][dy] = 2;
                    queue1.offer(new int[]{dx, dy});
                }
            }
            if(queue.isEmpty()&&!queue1.isEmpty()){
                queue.addAll(queue1);
                while(!queue1.isEmpty()){
                    queue1.poll();
                }
                sum++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return sum;
    }
}
