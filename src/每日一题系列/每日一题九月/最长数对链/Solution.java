package 每日一题系列.每日一题九月.最长数对链;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        int curMax = 1;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] == 0 ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        if (pairs.length <= 1) {
            return curMax;
        }
        int nextFrist;
        int curData = pairs[0][1];
        for (int i = 0; i < pairs.length - 1; i++) {
            nextFrist = pairs[i + 1][0];
            if (curData < nextFrist) {
                curMax++;
                curData = pairs[i+1][1];
            }
        }
        return curMax;
    }
}
