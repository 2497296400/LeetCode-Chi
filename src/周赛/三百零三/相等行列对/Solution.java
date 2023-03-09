package 周赛.三百零三.相等行列对;

public class Solution {
    public int equalPairs(int[][] grid) {
        int sum=0;
        for(int i=0;i<grid.length;i++){
            int curStart=grid[i][0];
            for(int j=0;j<grid[0].length;j++){
                int curLine=grid[0][j];
                if(curStart==curLine){
                    int flag=0;
                    for(int strat=0;strat<grid[0].length;strat++){
                        if(grid[i][strat]!=grid[strat][j]){
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
