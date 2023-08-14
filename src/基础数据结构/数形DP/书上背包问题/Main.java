package 基础数据结构.数形DP.书上背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] value;
    static int[] father;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        value = new int[n + 1];
        father = new int[n + 1];
        g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            value[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            father[u] = v;
            g[v].add(u);
        }
        int fa = 0;
        for (int i = 1; i < n + 1; i++) {
            if (father[i] == 0) {
                fa = i;
                break;
            }
        }
        dp = new int[n + 1][2];
        dfs(fa);
        System.out.println(Math.max(dp[fa][0], dp[fa][1]));
    }

    static int[][] dp;

    private static void dfs(int fa) {
        dp[fa][1] = value[fa];
        for (Integer son : g[fa]) {
            if (fa == son) continue;
            dfs(son);
        }
        for (Integer son : g[fa]) {
            dp[fa][1] += dp[son][0];
            dp[fa][0] += Math.max(dp[son][0], dp[son][1]);
        }
    }
}
