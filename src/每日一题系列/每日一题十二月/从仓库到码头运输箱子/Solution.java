package 每日一题系列.每日一题十二月.从仓库到码头运输箱子;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        Deque<int[]> deque = new ArrayDeque<>();
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        int dif = 0, wei = 0;
        for (int i = 1; i <= n; i++) {
            int cur = dp[i - 1] + 2;
            dif += i >= 2 && boxes[i - 1][0] != boxes[i - 2][0] ? 1 : 0;
            wei += boxes[i - 1][1];
            while (!deque.isEmpty() && deque.peekLast()[1] + dif >= cur) deque.pollLast();
            deque.add(new int[]{i, cur - dif, boxes[i - 1][1] - wei});
            while (deque.peekFirst()[0] <= i - maxBoxes || deque.peekFirst()[2] + wei > maxWeight) deque.pollFirst();
            dp[i] = deque.peekFirst()[1] + dif;
        }
        return dp[n];
    }
}
