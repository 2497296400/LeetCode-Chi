package 周赛.三百五十六场.第一题;

public class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target) ans++;
        }
        return ans;
    }
}
