package 二分查找类型.寻找峰值;

public class Solution {

    public static int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return right;
    }
}
