package 基础数据结构.埃式素数塞;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 10;
        boolean[] vis = new boolean[n + 2];
        int[] pri = new int[n + 2];
        int curIndex = 0;
        for (int i = 2; i < n; i++) {
            if (!vis[i]) {
                pri[++curIndex] = i;
            }
            for (int j = 1; j <= curIndex && pri[j] * i <= n; j++) {
                vis[pri[j] * i] = true;
                if (i % pri[j] == 0) {
                    break;
                }
            }
        }
        for (int i = 2; i <= curIndex; i++) {
            System.out.println(pri[i]);
        }
        test();
    }

    private static  void test() {
        int n = 100;
        boolean[] vis = new boolean[n + 1];
        int[] isT = new int[n + 1];
        int curSum = 0;
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                isT[++curSum] = i;
            }
            for (int j = 1; j <= curSum && isT[j] * i <= n; j++) {
                vis[isT[j] * i] = true;
                if(i%isT[j]==0){
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(isT));
    }
}
