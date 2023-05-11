package 周赛.三百四十一场.第二题;

public class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int index = divisors[0];
        int curSum = 0;
        for (int i = 0; i < divisors.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    sum++;
                }
            }
            if (sum == curSum) {
                index = Math.min(index, divisors[i]);
            } else if (sum > curSum) {
                curSum = sum;
                index = divisors[i];
            }
        }
        return index;
    }
}
