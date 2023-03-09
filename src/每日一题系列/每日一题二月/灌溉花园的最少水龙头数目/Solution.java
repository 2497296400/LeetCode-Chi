package 每日一题系列.每日一题二月.灌溉花园的最少水龙头数目;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {
                1, 2, 1, 0, 2, 1, 0, 1};
        System.out.println(solution.minTaps(7, arr));
    }

    
    public int minTaps(int n, int[] ranges) {
        int[][] ra = new int[n + 1][2];
        for (int i = 0; i < ranges.length; i++) {
            ra[i][0] = Math.max(0, i - ranges[i]);
            ra[i][1] = Math.min(n, i + ranges[i]);
        }
        Arrays.sort(ra, (o1, o2) -> {
            if (o2[0] == o1[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < ra.length; i++) {
            if (ra[i][0] > cur) {
                if (priorityQueue.isEmpty()) {
                    return -1;
                }
                int[] ints = priorityQueue.poll();
                cur = ints[1];
                ans++;
            }
            if (ra[i][1] > cur) {
                priorityQueue.add(new int[]{cur, ra[i][1]});
            }
        }
        if (cur < n ) {
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            int[] poll = priorityQueue.poll();
            if (poll[1] >= n ) {
                return ans + 1;
            }
            return -1;
        }
        return ans;
    }
}
