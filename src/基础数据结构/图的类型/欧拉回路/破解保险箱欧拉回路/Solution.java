package 基础数据结构.图的类型.欧拉回路.破解保险箱欧拉回路;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.crackSafe(3, 3));
    }
    public Set<Integer> vis = new HashSet<>();
    StringBuilder stringBuilder = new StringBuilder();

    public String crackSafe(int n, int k) {
        int MOD = (int) Math.pow(10, n - 1);
        dfs(0, k, MOD);
        stringBuilder.append("0".repeat(n - 1));
        return stringBuilder.reverse().toString();
    }

    private void dfs(int root, int k, int MOD) {
        for (int i = 0; i < k; i++) {
            int v = root * 10 + i;
            if (vis.contains(v)) {
                continue;
            }
            vis.add(v);
            dfs(v % MOD, k, MOD);
            stringBuilder.append(i);
        }
    }
}
