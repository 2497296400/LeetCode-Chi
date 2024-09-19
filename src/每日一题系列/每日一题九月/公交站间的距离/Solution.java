package 每日一题系列.每日一题九月.公交站间的距离;

public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int i : distance) {
            sum += i;
        }
        int ans = 0;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i = start; i < destination; i++) {
            ans += distance[i];
        }
        return Math.min(ans, sum - ans);
    }
}
