package 子数组问题.区间子数组个数;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
        System.out.println(solution.numSubarrayBoundedMax(arr, 32, 69));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int cur = -1;
        int tmep = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                cur = i;
            }
            if (nums[i] >= left) {
                tmep = i - cur;
            }
            ans += tmep;
        }
        return ans;
    }
}
