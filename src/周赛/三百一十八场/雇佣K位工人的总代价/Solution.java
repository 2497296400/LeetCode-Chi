package 周赛.三百一十八场.雇佣K位工人的总代价;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 4, 1};
        System.out.println(solution.totalCost(arr, 3, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> f = new PriorityQueue<>();
        PriorityQueue<Integer> s = new PriorityQueue<>();
        long sum = 0;
        int left = 0;
        int right = costs.length - 1;
        for (int i = 0; i < k; i++) {
            while (left < right && f.size() < candidates) {
                f.add(costs[left++]);
            }
            while (right >= left && s.size() < candidates) {
                s.add(costs[right--]);
            }
            if (!s.isEmpty() && !f.isEmpty()) {
                sum += s.peek() < f.peek() ? s.poll() : f.poll();
            } else if (s.isEmpty()) {
                sum += f.poll();
            } else {
                sum += s.poll();
            }
        }
        return sum;
    }
}
