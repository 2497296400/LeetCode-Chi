package 丑数系列.丑数II;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = {2, 3, 5};
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int cur = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (cur % 2 == 0) {
                p2++;
            }
            if (cur % 3 == 0) {
                p3++;
            }
            if (cur % 5 == 0) {
                p5++;
            }
            res[i] = cur;
        }
        return res[n - 1];
    }
}
