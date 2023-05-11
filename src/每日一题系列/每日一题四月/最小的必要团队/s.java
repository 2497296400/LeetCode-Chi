package 每日一题系列.每日一题四月.最小的必要团队;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solutions {
    public static void main(String[] args) {
        Solutions solution = new Solutions();
        String[] re = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        List<List<String>> list = new ArrayList<>();
        String[][] p = {{"algorithms", "math", "java"}, {"algorithms", "math", "reactjs"}, {"java", "csharp", "aws"}, {"reactjs", "csharp"}, {"csharp", "math"}, {"aws", "java"}};


        for (int i = 0; i < p.length; i++) {
            list.add(List.of(p[i]));
        }
        System.out.println(Arrays.toString(solution.smallestSufficientTeam(re, list)));
    }

    private long all;
    private int[] mask;
    private long[][] memo;

    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        var sid = new HashMap<String, Integer>();
        int m = reqSkills.length;
        for (int i = 0; i < m; ++i)
            sid.put(reqSkills[i], i); // 字符串映射到下标

        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; ++i)
            for (var s : people.get(i)) // 把 people[i] 压缩成一个二进制数 mask[i]
                mask[i] |= 1 << sid.get(s);

        int u = 1 << m;
        memo = new long[n][u];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1); // -1 表示还没有计算过
        all = (1L << n) - 1;
        long res = dfs(n - 1, u - 1);

        var ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < n; ++i)
            if (((res >> i) & 1) > 0)
                ans[j++] = i; // 所有在 res 中的下标
        return ans;
    }

    private long dfs(int i, int j) {
        if (j == 0) return 0; // 背包已装满
        if (i < 0) return all; // 没法装满背包，返回全集，这样下面比较集合大小会取更小的
        if (memo[i][j] != -1) return memo[i][j];
        long res2 = dfs(i - 1, j & ~mask[i]) | (1L << i); // 选 mask[i]
        long res = dfs(i - 1, j); // 不选 mask[i]
        System.out.println(mask[i]+" " +~mask[i]);
        return memo[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
    }
}