package 基础数据结构.埃式素数塞;

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
    }

    private void t() {
        int n = 100;
        int[] arr = new int[n];
        int curSum = 0;
        boolean[] vis = new boolean[n];
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                arr[++curSum] = i;
            }
            for (int j = 1; j <= curSum && i * arr[j] <= n; j++) {
                vis[i * arr[j]] = true;
                if (i%arr[j]==0){
                    break;
                }
            }
        }
    }
}
