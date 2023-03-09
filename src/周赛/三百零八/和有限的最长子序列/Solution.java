package 周赛.三百零八.和有限的最长子序列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={4,5,2,1};
        int []q={3,10,21};
        System.out.println(Arrays.toString(solution.answerQueries(nums, q)));
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int []ans=new int[queries.length];
        int len=0;
        int []cur=new int[nums.length];
        cur[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            cur[i]+=cur[i-1]+nums[i];
        }
        for (int query : queries) {
           for(int i=0;i<cur.length;i++){
               if(query<cur[i]){
                   ans[len++]=i;
                   break;
               }
               else if(i==cur.length-1||query==cur[i]){
                   ans[len++]=i+1;
                   break;
               }
           }
        }
        return ans;
    }
}
