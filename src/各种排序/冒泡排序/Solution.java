package 各种排序.冒泡排序;

public class Solution {
    public static void Sort(int [] nums){
        for(int i=nums.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
