package 每日一题系列.每日一题十月.完成旅途的最少时间;

public class Solution {
    public static void main(String[] args) {
        int[] p = {39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25};
        int totalTrips = 4187;
        Solution solution = new Solution();
        System.out.println(solution.minimumTime(p, totalTrips));
    }

    public long minimumTime(int[] time, int totalTrips) {
        int len = time.length;
        long left = 0, right = 100000000000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long maxTime = 0;
            for (int i = 0; i < len; i++) {
                maxTime += mid / time[i];
            }
            if (maxTime >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
