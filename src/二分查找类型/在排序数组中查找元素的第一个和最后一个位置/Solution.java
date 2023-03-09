package 二分查找类型.在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int right = 0, left = 0;
        int[] ans = new int[2];
        boolean LR = true;
        left = GetLR(nums, target, LR);
        LR = false;
        right = GetLR(nums, target, LR);
        ans[0] = left;
        ans[1] = right;
        return ans;
    }

    private int GetLR(int[] nums, int target, boolean lr) {
        int left = 0;
        int right = nums.length - 1;
        int ans=-1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                ans=mid;
                if (lr) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ans;
    }
}
