package 每日一题系列.每日一题六月.重构2行二进制矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        int oneSum = 0;
        int zeroSum = 0;
        int towSum = 0;
        for (int i : colsum) {
            if (i == 0) {
                zeroSum++;
            } else if (i == 1) {
                oneSum++;
            } else {
                towSum++;
            }
        }
        int preOne = upper - towSum;
        int nextOne = lower - towSum;
        if (preOne < 0 || nextOne < 0 || preOne + nextOne != oneSum) {
            return ans;
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        for (int i : colsum) {
            if (i == 0) {
                pre.add(0);
                next.add(0);
            } else if (i == 1) {
                if (preOne > 0) {
                    pre.add(1);
                    next.add(0);
                    preOne--;
                } else {
                    pre.add(0);
                    next.add(1);
                    nextOne--;
                }
            } else {
                pre.add(1);
                next.add(1);
            }
        }
        ans.add(pre);
        ans.add(next);
        return ans;
    }
}
