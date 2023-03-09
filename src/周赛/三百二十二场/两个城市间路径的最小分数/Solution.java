package 周赛.三百二十二场.两个城市间路径的最小分数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        System.out.println(solution.minScore(4, arr));
    }

    public int minScore(int n, int[][] roads) {
        List<int[]>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            list[road[0]].add(new int[]{road[1], road[2]});
            list[road[1]].add(new int[]{road[0], road[2]});
        }
        int curMin = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        HashSet<Integer> hashSet = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            hashSet.add(curNode);
            for (int[] ints : list[curNode]) {
                if (!hashSet.contains(ints[0])) {
                    queue.add(ints[0]);
                    curMin = Math.min(ints[1], curMin);
                }
            }
        }
        return curMin;
    }
}
