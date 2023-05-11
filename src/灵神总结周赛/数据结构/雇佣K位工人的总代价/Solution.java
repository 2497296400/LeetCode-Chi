package 灵神总结周赛.数据结构.雇佣K位工人的总代价;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println(solution.totalCost(arr, 3, 4));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> f = new PriorityQueue();
        PriorityQueue<Integer> s = new PriorityQueue();
        long ans = 0L;
        int l = 0, r = costs.length - 1;
        while (k > 0) {
            while (f.size() < candidates && l < r) {
                f.add(costs[l++]);
            }
            while (s.size() < candidates && l <= r) {
                s.add(costs[r--]);
            }
            if (f.isEmpty()) {
                ans += s.poll();
            } else if (s.isEmpty()) {
                ans += f.poll();
            } else {
                if (f.peek() > s.peek()) {
                    ans += s.poll();
                } else {
                    ans += f.poll();
                }
            }
            k--;
        }
        return ans;
    }
}
