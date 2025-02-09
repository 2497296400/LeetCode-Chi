package 每日一题系列.每日一题一月.范围内整数的最大得分;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] start = {6,0,3};
        int d = 2;
        System.out.println(solution.maxPossibleScore(start, d));
    }
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean can = true;
            int pre = start[0];

            for (int i = 1; i < start.length; i++) {
                int next = start[i];
                if (next + d - pre < mid) {
                    can = false;
                    break;
                }
                int deep = next - pre - mid;
                if (deep >= 0) {
                    pre = next;
                } else {
                    pre = next - deep;
                }
            }
            if (can) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l-1;
    }
}
