package 周赛.七十四周.第二题;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int [][]artifacts= {{0,0,0,0},{0,1,1,1}};
        int [][]dig={{0,0},{0,1}};
        System.out.println(digArtifacts(5,artifacts,dig));
    }
    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
      int sum=0;
      int [][]map=new int[n][n];
      for(int i=0;i<n;i++){
          Arrays.fill(map[i],0);
      }
      for(var str:dig){
          map[str[0]][str[1]]=1;
      }
      for(int i=0;i<artifacts.length;i++){
          if(zuobiao(artifacts[i],map)){
              sum++;
          }
      }
      return sum;
    }

    private static boolean zuobiao(int[] artifact, int[][] map) {
       for(var i=artifact[0];i<=artifact[2];i++){
           for(var j=artifact[1];j<=artifact[3];j++){
               if(map[i][j]!=1){
                   return false;
               }
           }
        }
       return true;
    }
}