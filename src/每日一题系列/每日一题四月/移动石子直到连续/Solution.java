package 每日一题系列.每日一题四月.移动石子直到连续;

import java.util.Arrays;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        int[] ans = new int[2];
        Arrays.sort(arr);
        int deep = 0;
        int f = arr[1] - arr[0];
        int s = arr[2] - arr[1];
        int max = f + s - 2;
        ans[1] = max;
        if (f == 1 && s == 1) {
            ans[0] = 0;
        } else if (f == 1 || s == 1 || f == 2||s==2) {
            ans[0] = 1;
        } else {
            ans[0] = 2;
        }
        return ans;
    }
}
