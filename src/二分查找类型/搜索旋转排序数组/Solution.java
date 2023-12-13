package 二分查找类型.搜索旋转排序数组;

class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                // 说明左边是有序的
                if (nums[l] <= nums[mid]) {
                    // target在左边
                    if (nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        // target在右边
                        l = mid + 1;
                    }
                } else {
                    // 说明右边是有序的
                    // target在右边
                    if (nums[mid] < target && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        // target在左边
                        r = mid - 1;
                    }
                }
            }
        }
        return 0;
    }
}