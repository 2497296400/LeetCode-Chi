package 二分查找类型.搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        if (target <= nums[0]) {
            return 0;
        } else if (target >= nums[right]) {
            return right + 1;
        } else {
            while (true) {
                mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    break;
                } else if (nums[mid] < target && target < nums[mid + 1]) {
                    mid++;
                    break;
                }
                if (target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return mid;
    }
}
