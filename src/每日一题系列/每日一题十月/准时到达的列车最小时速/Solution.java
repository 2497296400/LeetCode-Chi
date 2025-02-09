package 每日一题系列.每日一题十月.准时到达的列车最小时速;

public class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int len = dist.length;
        if (len - 1 > hour) {
            return -1;
        }
        int left = 1, right = 10000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            double time = 0;
            for (int i = 0; i < len - 1; i++) {
                time += Math.ceil((double) dist[i] / mid);
            }
            time += (double) dist[len - 1] / mid;
            if (time > hour) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
