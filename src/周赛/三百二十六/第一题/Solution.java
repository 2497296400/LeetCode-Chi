package 周赛.三百二十六.第一题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.closestPrimes(1, 1000000)));
    }
    public int[] closestPrimes(int left, int right) {
        int[] br = new int[right + 1];
        boolean[] vis = new boolean[right + 1];
        int curIndex = 0;
        for (int i = 2; i <= right; i++) {
            if (!vis[i]) {
                br[++curIndex] = i;
            }
            for (int j = 1; j <= curIndex && br[j] * i <= right; j++) {
                vis[br[j] * i] = true;
                if (i % br[j] == 0) {
                    break;
                }
            }
        }
        int l = 0;
        int[] ans = new int[]{-1, -1};
        int r = Integer.MAX_VALUE;
        for (int i = 1; i <=curIndex-1; i++) {
            if (br[i] >= left) {
                int cl = br[i];
                int cr = br[i + 1];
                int d = cr - cl;
                if (d < r - l) {
                    l = cl;
                    r = cr;
                    ans[0] = l;
                    ans[1] = r;
                }
            }
        }
        return ans;
    }
}
