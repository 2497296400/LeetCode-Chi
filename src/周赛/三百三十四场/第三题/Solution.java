package 周赛.三百三十四场.第三题;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sr = {1, 1};
        int[] ed = {10, 8};
        int[][] g = {{6, 4, 9, 7, 1}, {5, 2, 2, 1, 3}, {3, 2, 5, 5, 2}};
        System.out.println(solution.minimumCost(sr, ed, g));
    }

    public long minimumCost(int[] start, int[] target, int[][] specialRoads) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        pq.add(new int[]{0, start[0], start[1]});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // System.out.println(Arrays.toString(poll));
            if (!map.containsKey(List.of(poll[1], poll[2]))) {
                map.put(List.of(poll[1], poll[2]), poll[0]);
                for (int[] road : specialRoads) {
                    int value = Math.abs(road[0] - poll[1]) + Math.abs(road[1] - poll[2]) + poll[0] + road[4];
                   // System.out.println(Arrays.toString(poll) + " " + Arrays.toString(road) + " " + value);
                    pq.add(new int[]{value, road[2], road[3]});
                }
                int value = Math.abs(target[0] - poll[1]) + Math.abs(target[1] - poll[2])+poll[0];
                pq.add(new int[]{value, target[0], target[1]});
            }
        }
        return map.get(List.of(target[0], target[1]));
    }
}
