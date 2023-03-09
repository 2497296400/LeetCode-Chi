package 网易五道题.分发糖果;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,6,10,8,7,3,2};
        Solution solution = new Solution();
        System.out.println(solution.candy(nums));
    }
    public int candy(int[] ratings) {
        int []condySum=new int[ratings.length];
        Arrays.fill(condySum, 1);
        for(int i=0;i<ratings.length-1;i++){
            if(ratings[i+1]>ratings[i]){
                condySum[i+1]=condySum[i]+1;
            }
        }
        for(int i=ratings.length-1;i>=1;i--){
            if(ratings[i-1]>ratings[i]){
                condySum[i-1]=Math.max(condySum[i-1],condySum[i]+1);
            }
        }
        int curSum=0;
        for (int i : condySum) {
            curSum+=i;
        }
        return curSum;
    }
}
