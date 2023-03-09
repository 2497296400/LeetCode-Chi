package 每日一题系列.每日一题七月.有效正方形;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []p1={0,0};
        int []p2={1,1};
        int []p3={0,0};
        int []p4={0,0};
        System.out.println(solution.validSquare(p1,p2,p3,p4));
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int []>list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Set<Double> set=new HashSet<>();

        for(int i=0;i<4;i++){
            int curX=list.get(i)[0];
            int curY=list.get(i)[1];
            for(int j=0;j<4;j++){
                if(j!=i){
                    int nextX=list.get(j)[0];
                    int nextY=list.get(j)[1];
                   set.add(fun(curX,curY,nextX,nextY));
                }
            }
        }
        return set.size() == 2 && !set.contains(0.0);
    }
    private double fun(int curX, int curY, int nextX, int nextY) {
        return Math.sqrt((nextX-curX)*(nextX-curX)+(nextY-curY)*(nextY-curY));
    }
}
