package 周赛.三百一十八场.最小移动总距离;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = List.of(9, 11, 99, 101);
        int[] arr = {9, 11, 99, 101};
        int[][] srr = {{10, 1}, {7, 1}, {14, 1}, {100, 1}, {96, 1}, {103, 1}};
        System.out.println(solution.minimumTotalDistance(list1, srr));
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] re = new int[robot.size()];
        int len = 0;
        for (Integer integer : robot) {
            re[len++] = integer;
        }
        long sum = 0;
        Arrays.sort(re);
        long[][] dp = new long[re.length][factory.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(0, 0, re, factory, dp);
    }

    private long fun(int i, int j, int[] re, int[][] factory, long[][] dp) {
        if (i == re.length) {
            return 0;
        }
        if (j == factory.length - 1) {
            if (re.length - i > factory[j][1]) {
                return Long.MAX_VALUE/2;
            }
            long sum = 0;
            for (int cur = i; cur < re.length; cur++) {
                sum += Math.abs(re[cur] - factory[j][0]);
            }
            return sum;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long next = fun(i, j + 1, re, factory, dp);
        long s = 0;
        int k = 1;
        while (k <= factory[j][1] && i + k - 1 < re.length) {
            s += Math.abs(factory[j][0] - re[i + k - 1]);
            next = Math.min(next, fun(i + k, j + 1, re, factory, dp) + s);
            k++;
        }
        dp[i][j] = next;

        return next;
    }
}
