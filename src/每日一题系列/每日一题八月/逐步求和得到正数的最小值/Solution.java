package 每日一题系列.每日一题八月.逐步求和得到正数的最小值;

class Solution {
    public int minStartValue(int[] nums) {
        int min = 0, cur = 0;
        for (int num : nums) {
            if ((cur += num) < 0 && cur < min) {
                min = cur;
            }
        }
        return min == 0 ? 1 :  0 - min + 1;
    }
}