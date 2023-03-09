package 双指针问题.区间列表的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  static   int tep=0;
    public static void main(String[] args) {
        int [][]first={ {0,2},{5,10},{13,23},{24,25}},second={{1,5},{8,12},{15,24},{25,26}};

      int [][]temp=intervalIntersection(first,second);
      for(int i=0;i<tep;i++){
          System.out.println(Arrays.toString(temp[i]));
      }
    }
    public static int [][]intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int []>arr=new ArrayList<>();
      int first=0;
      int senced=0;
      while (first<firstList.length&&senced<secondList.length){
          int F=firstList[first][0];
          int S=secondList[senced][0];
          int FM=firstList[first][1];
          int SM=secondList[senced][1];
          int fir=Math.max(F,S);
          int las=Math.min(FM,SM);
          if(fir<=las){
         arr.add(new int []{fir,las});
          }
          if(las==FM){
              first++;
          }
          else if(las==SM){
              senced++;
          }
      }
      return arr.toArray(new int[0][]);
    }
}
