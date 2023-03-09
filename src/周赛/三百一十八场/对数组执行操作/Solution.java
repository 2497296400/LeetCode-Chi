package 周赛.三百一十八场.对数组执行操作;

public class Solution {
    public int[] applyOperations(int[] nums) {
        int[] arr = new int[nums.length];
        int pre = nums[0];
        int len = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                nums[i] = 2 * nums[i + 1];
                nums[i+1]=0;
            }
        }

        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                arr[len++]=nums[i];
            }
        }
        return arr;
    }
}
