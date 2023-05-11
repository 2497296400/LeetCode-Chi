package 灵神总结周赛.动态规划.最小移动总距离;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, Comparator.comparingInt(o -> o[0]));
        robot.sort(Comparator.comparingInt(o1 -> o1));
        long[][] dp = new long[robot.size()][factory.length];
        for (int i = 0; i < robot.size(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(factory, robot, 0, 0, dp);
    }

    private long fun(int[][] factory, List<Integer> robot, int i, int j, long[][] dp) {
        if (i == robot.size()) {
            return 0;
        }
        if (j == factory.length - 1) {
            if (factory[j][1] < robot.size() - i) {
                return Long.MAX_VALUE/2;
            }
            long cur = 0L;
            for (int k = i; k < robot.size(); k++) {
                cur += Math.abs(robot.get(k) - factory[j][0]);
            }
            return cur;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long asn = fun(factory,robot,i,j+1,dp);
        int k = 0;
        long cur = 0L;
        while (k < factory[j][1] && i + k < robot.size()) {
            cur += Math.abs(robot.get(i + k) - factory[j][0]);
            asn = Math.min(asn, fun(factory, robot, i + k, j + 1, dp) + cur);
            k++;
        }
        return dp[i][j] = asn;
    }
}
