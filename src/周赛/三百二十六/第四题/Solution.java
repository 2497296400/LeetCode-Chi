package 周赛.三百二十六.第四题;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countDigits(10000);
    }
    public void countDigits(int num) {
        int r = 100000;
        int curIndex = 0;
        boolean[] vis = new boolean[r + 1];
        int[] pre = new int[r + 1];
        for (int i = 2; i <= r; i++) {
            if (!vis[i]) {
                pre[++curIndex] = i;
            }
            for (int j = 1; j <= curIndex && i * pre[j] <= r; j++) {
                vis[i * pre[j]] = true;
                if(i%pre[j]==0){
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(pre,curIndex)));
    }
}
