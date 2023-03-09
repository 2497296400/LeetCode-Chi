package 每日一题系列.每日一题八月.数组中两元素的最大乘积;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curMax = 0;
        int curPreMax = 0;
        int firstIndex = 0;
        int nextIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
                firstIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > curPreMax && i != firstIndex) {
                curPreMax =  nums[i];
                nextIndex = i;
            }
        }
        return (curMax - 1) * (curPreMax - 1);
    }
}
