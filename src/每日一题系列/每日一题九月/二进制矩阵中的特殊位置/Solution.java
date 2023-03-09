package 每日一题系列.每日一题九月.二进制矩阵中的特殊位置;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSpecial(int[][] mat) {
        int ans=0;
        ArrayList<Data>dataArrayList=new ArrayList<>();
        for(int i=0;i<mat.length;i++) {
            int curSum=0;
            int lin=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    curSum++;
                    lin=j;
                }
                if(curSum>1){
                    break;
                }
            }
            if(curSum==1){
                dataArrayList.add(new Data(i,lin));
            }
        }
        for (Data data : dataArrayList) {
            int line=data.line;
            int curSum=0;
            for(int i=0;i<mat.length;i++){
                if(mat[i][line]==1){
                    curSum++;
                }
                if(curSum>1){
                    break;
                }
            }
            if(curSum==1){
                ans++;
            }
        }
        return ans;
    }
}
class Data{
    int row;
    int line;

    public Data(int row, int line) {
        this.row = row;
        this.line = line;
    }
}
