package 贪心算法.洗衣机问题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int []nums={1,0,5};
        System.out.println(findMinMoves(nums));

    }
    public static int findMinMoves(int[] machines) {
        if(machines==null||machines.length==0){
            return -1;
        }
        int sum= Arrays.stream(machines).sum();
        if(sum%machines.length!=0){
            return -1;
        }
        int avg=sum/machines.length;
        int leftsum=0;
        int ans=0;
        for(int i=0;i<machines.length;i++){
            int leftnend=leftsum-avg*i;
            int rightneed=sum-leftsum-(machines.length-i-1)*avg-machines[i];
            if(leftnend<0&&rightneed<0){
                ans=Math.max(ans, Math.abs(leftnend+rightneed));
            }
            else {
                ans=Math.max(ans,Math.max(Math.abs(leftnend),Math.abs(rightneed)));
            }
            leftsum+=machines[i];

        }
        return ans;

    }
}
