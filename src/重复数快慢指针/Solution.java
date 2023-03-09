package 重复数快慢指针;
//二分查找类型.二分查找
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        right-=1;
        while (left != right) {
            int sum = 0;
            for (int i =0; i <n; i++) {
                if (nums[i] <= mid) {
                    sum++;
                }
            }
            if (sum > mid) {
                right = mid;
            } else {
                left = mid+1;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }
}
