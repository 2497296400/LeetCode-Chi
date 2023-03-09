package 各种排序.插入排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int []nums={1,5,9,0,3,5,4};
        Sort(nums);
        Sort1(nums);
    }
    public static void Sort(int []nums){
        for(int i=1;i<nums.length;i++){
            int value=nums[i];
            int position=i;
            while (position>0&&nums[position-1]>value){
                nums[position]=nums[position-1];
                position--;
            }
            nums[position]=value;
        }
        System.out.println(Arrays.toString(nums));
    }
    private static void  Sort1(int []nums){
        for(int i=1;i<nums.length;i++){
            for(int j=i;j>0&&nums[j]<nums[j-1];j--){
                swap(nums,j,j-1);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int j, int i) {
        nums[j]=nums[j]^nums[i];
        nums[i]=nums[j]^nums[i];
        nums[j]=nums[j]^nums[i];
    }
}
