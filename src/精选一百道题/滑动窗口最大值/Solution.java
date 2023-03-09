package 精选一百道题.滑动窗口最大值;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> curWin = new LinkedList<>();
        if (nums == null || k < 1 || nums.length < k - 1) {
            return null;
        }
        int[] ans = new int[nums.length - k + 1];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!curWin.isEmpty() && nums[curWin.peekLast()] <= nums[i]) {
                curWin.pollLast();
            }
            curWin.add(i);
            if (curWin.peekFirst() == i - k) {
                curWin.pollFirst();
            }
            if (i >= k - 1) {
                ans[len++] = nums[curWin.peekFirst()];
            }
        }
        return ans;
    }
}
