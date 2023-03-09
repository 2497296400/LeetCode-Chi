package 精选一百道题.合并区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1, 4}, {2, 3}};
        System.out.println(Arrays.deepToString(merge(nums)));
    }

    public static int[][] merge(int[][] intervals) {
        int[][] nums = new int[intervals.length][2];
        int j = -1;
        int i = 0;
        int temp = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (i = 0; i < intervals.length; i = j) {
            int strat = intervals[i][0];
            int end = intervals[i][1];
            for (j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] > end) {
                    break;
                }
                if (intervals[j][0] <= end && intervals[j][1] > end) {
                    end = intervals[j][1];
                }
            }
            nums[temp++] = new int[]{strat, end};
        }
        int[][] ans = new int[temp][2];
        for (int k = 0; k < temp; k++) {
            ans[k][0] = nums[k][0];
            ans[k][1] = nums[k][1];
        }

        return ans;
    }
}
