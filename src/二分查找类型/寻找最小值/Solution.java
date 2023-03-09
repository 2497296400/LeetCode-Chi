package 二分查找类型.寻找最小值;

public class Solution {
    public static void main(String[] args) {
        int []nums={1,3,5,9,0,2,4};
        System.out.println(findMin(nums));

    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return  nums[left];
    }
}
