package 翻转数组;

import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        resver(nums,0,nums.length-1);
        resver(nums,0,k-1);
        resver(nums,k,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    private void resver(int []nums,int start,int end) {
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
