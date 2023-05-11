package 灵神总结周赛.数据结构.会议室III;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{0, 10}, {1, 5}, {2, 7}, {3, 4}, {8, 11}, {9, 12}};
        System.out.println(solution.mostBooked(2, g));
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] srr = new int[2];
        int[] arr = new int[n];
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        int max = 0;
        PriorityQueue<Integer> idpq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            idpq.add(i);
        }
        PriorityQueue<long[]> mpq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Math.toIntExact(o1[0] - o2[0]);
            }
            return Math.toIntExact(o1[1] - o2[1]);
        });
        for (int[] meeting : meetings) {
            long strat = meeting[0], end = meeting[1];
            while (!mpq.isEmpty() && mpq.peek()[1] <= strat) {
                idpq.add((int) mpq.poll()[0]);
            }
            int id;
            if (idpq.isEmpty()) {
                long[] poll = mpq.poll();
                id = (int) poll[0];
                end = end - strat + poll[1];
                System.out.println(end);
            } else {
                id = idpq.poll();
            }
            arr[id]++;
            mpq.add(new long[]{id, end});
        }
        int ans = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                ans = i;
                max = arr[i];
            }
        }
        return ans;
    }
}