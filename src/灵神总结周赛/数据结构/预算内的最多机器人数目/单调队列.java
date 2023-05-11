package 灵神总结周赛.数据结构.预算内的最多机器人数目;

import java.util.ArrayDeque;
import java.util.Deque;

public class 单调队列 {
    public static void main(String[] args) {
        单调队列 单调队列 = new 单调队列();
        int[] arr = {19, 63, 21, 8, 5, 46, 56, 45, 54, 30, 92, 63, 31, 71, 87, 94, 67, 8, 19, 89, 79, 25};
        int[] srr = {91, 92, 39, 89, 62, 81, 33, 99, 28, 99, 86, 19, 5, 6, 19, 94, 65, 86, 17, 10, 8, 42};
        System.out.println(单调队列.maximumRobots(arr, srr, 85));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> deque = new ArrayDeque<>();
        long curSum = 0L;
        int ans = 0;
        int l = 0, r = 0;
        while (r < chargeTimes.length) {
            int curMax = 0;
            while (!deque.isEmpty() && chargeTimes[r] >= chargeTimes[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(r);
            curSum += runningCosts[r];
            while (!deque.isEmpty() && chargeTimes[deque.peekFirst()] + (r - l + 1) * curSum > budget) {
                if (deque.peekFirst() == l) {
                    deque.pollFirst();
                }
                curSum -= runningCosts[l++];
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
