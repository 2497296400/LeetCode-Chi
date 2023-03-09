package 每日一题系列.每日一题七月.玩筹码;
public class Solution {
    public int minCostToMoveChips(int[] position) {
      int sum1=0;
      int sum2=0;
        for (int i : position) {
            if(i%2==0){
                sum2++;
            }else {
                sum1++;
            }
        }
        return Math.min(sum1, sum2);
    }
}
