package 动态规划问题.跳跃游戏二;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        int spet=0;
        int footMax=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            footMax=Math.max(footMax,nums[i]+i);
            if(i==end){
                end=footMax;
                spet++;
            }
            if(end>=nums.length-1){
                break;
            }
        }
        return spet;
    }
}
