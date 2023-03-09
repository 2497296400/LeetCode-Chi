package 周赛.三百二十八场.第一题;

public class Solution {
    public int differenceOfSum(int[] nums) {
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        long isSum = 0L;
        for (int num : nums) {
            while (num != 0) {
                isSum += num % 10;
                num /= 10;
            }
        }
        return (int) Math.abs(isSum-sum);
    }
}
