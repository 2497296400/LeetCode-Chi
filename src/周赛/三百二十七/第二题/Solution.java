package 周赛.三百二十七.第二题;

import java.util.PriorityQueue;

public class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        long ans = 0L;
        while (k-- > 0) {
            Integer cur = priorityQueue.poll();
            ans += cur;
            cur = (cur + 2) / 3;
            priorityQueue.add(cur);
        }
        return ans;
    }
}
