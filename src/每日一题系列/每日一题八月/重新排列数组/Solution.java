package 每日一题系列.每日一题八月.重新排列数组;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int []ans=new int[2*n];
        int len=0;
        for(int i=0;i<n;i++){
            ans[len++]=nums[i];
            ans[len++]=nums[i+n];
        }
        return ans;
    }
}
