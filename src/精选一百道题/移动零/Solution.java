package 精选一百道题.移动零;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums={0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int less=-1;
        int left=0;
        int more = nums.length;
        while (left<more){
            if(nums[left]!=0){
                swap(++less,left,nums);
            }
            left++;
        }
    }

    private void swap(int i, int left, int[] nums) {
        int cur=nums[i];
        nums[i]=nums[left];
        nums[left]=cur;
    }
}
