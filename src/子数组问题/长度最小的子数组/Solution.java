package 子数组问题.长度最小的子数组;

public class Solution {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = left + 1;
        int ans = Integer.MAX_VALUE;
        int temp = nums[left];
        while (left < nums.length) {
            for (; left < nums.length; ) {
                if (temp < target && right < nums.length) {
                    temp += nums[right++];
                } else {
                    temp -= nums[left++];
                    if(target<=temp){
                    ans = Math.min(ans, right - left);}
                    break;
                }
            }
        }
      return ans==Integer.MAX_VALUE?0:ans;
    }
}
