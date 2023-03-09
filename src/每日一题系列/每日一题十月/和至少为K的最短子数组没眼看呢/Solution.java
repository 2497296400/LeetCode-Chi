package 每日一题系列.每日一题十月.和至少为K的最短子数组没眼看呢;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, -3,4};
        System.out.println(solution.shortestSubarray(arr, 6));
    }

    public int shortestSubarray(int[] nums, int k) {
        long[] pre = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = nums[i] + pre[i];
        }
        long ans = Long.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < pre.length; i++) {
            long curSum = pre[i];
            while (!deque.isEmpty() && curSum - pre[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && pre[deque.peekLast()] >= curSum) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans == Long.MAX_VALUE? -1 : (int) ans;
    }
}