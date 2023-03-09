package 每日一题系列.每日一题一月.还原排列的最少操作步数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reinitializePermutation(4));
    }

    public int reinitializePermutation(int n) {
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        int[] clone = pre.clone();
        int[] arr = new int[n];
        int ans = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = pre[i / 2];
                } else {
                    arr[i] = pre[n / 2 + (i - 1) / 2];
                }
            }
            ans++;
            pre = Arrays.copyOf(arr, arr.length);
            if (Arrays.equals(pre, clone)) {
                return ans;
            }
        }
    }
}
