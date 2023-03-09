package 每日一题系列.每日一题九月.旋转的数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(100));
    }

    public int rotatedDigits(int n) {
        Set<Integer> itself = new HashSet<>();
        itself.add(0);
        itself.add(1);
        itself.add(8);
        Set<Integer> curX = new HashSet<>();
        curX.add(2);
        curX.add(5);
        curX.add(6);
        curX.add(9);
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans += fun(i, itself, curX);
        }
        return ans;
    }

    private int fun(int cur, Set<Integer> itself, Set<Integer> curX) {
        boolean f = false;
        boolean s = false;
        while (cur > 0) {
            int curData = cur % 10;
            cur = cur / 10;
            if (itself.contains(curData)) {
                f = true;
            } else if (curX.contains(curData)) {
                s = true;
            } else {
                return 0;
            }
        }
        return s ? 1 : 0;
    }
}
