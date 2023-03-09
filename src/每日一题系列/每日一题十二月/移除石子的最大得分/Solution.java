package 每日一题系列.每日一题十二月.移除石子的最大得分;

import java.util.Arrays;

public class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] cur = {a, b, c};
        Arrays.sort(cur);
        int max = cur[2];
        int mid = cur[1];
        int min = cur[0];
        if (min + mid - max >= 0) {
            return ((mid + min) - max) / 2 + max;
        } else {
            return mid + min;
        }
    }
}
