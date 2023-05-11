package 灵神总结周赛.技巧.长度为K子数组中的最大和;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 1, 1, 7, 8, 9};
        System.out.println(solution.maximumSubarraySum(arr, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] arr = new int[max + 1];
        int l = 0, r = 0;
        long ans = 0L;
        long curSum = 0L;
        while (r < nums.length) {
            while (r < nums.length && r - l < k) {
                curSum += nums[r];
                arr[nums[r]]++;
                while (arr[nums[r]] > 1) {
                    curSum -= nums[l];
                    arr[nums[l++]]--;
                }
                r++;
            }
            ans = Math.max(curSum, ans);
            if (r - l  == k) {
                arr[nums[l]]--;
                curSum -= nums[l];
                l++;
            }
        }
        return ans;
    }
}
