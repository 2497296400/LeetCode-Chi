package 精选一百道题.任务调度器;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        char []chars={'A','A','A','B','B','B'};
      Solution solution=  new Solution();
        System.out.println(solution.leastInterval(chars,2));

    }
    public int leastInterval(char[] tasks, int n) {
        int  []nums=new int [26];
        for(int i=0;i<tasks.length;i++){
            nums[tasks[i]-'A']++;
        }
        Arrays.sort(nums);
        int curMax=nums[25];
        int curAns=(curMax-1)*(n+1)+1;
        for(int i=24;i>=0;i--){
            if(nums[i]==curMax){
                curAns++;
            }
        }
        return Math.max(curAns,tasks.length);


}}
