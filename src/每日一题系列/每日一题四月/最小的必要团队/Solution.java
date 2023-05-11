package 每日一题系列.每日一题四月.最小的必要团队;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
    Long[][] memo;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = req_skills.length;
        for (int i = 0; i < m; i++) {
            map.put(req_skills[i], i);
        }
        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String s : people.get(i)) {
                mask[i] |= 1<<map.get(s);
            }
        }
        memo = new Long[n][1 << m];
        all = (1L << n) - 1;
        long res = dfs(n - 1, (1 << m) - 1);
        int[] arr = new int[Long.bitCount(res)];
        for (int i = 0, len = 0; i < n; i++) {
            if (((res >> i) & 1) != 0) {
                arr[len++] = i;
            }
        }
        return arr;
    }

    private long dfs(int index, int status) {
        if (status == 0) {
            return 0;
        }
        if (index < 0) {
            return all;
        }
        if (memo[index][status] != null) {
            return memo[index][status];
        }
        long p1 = dfs(index - 1, status & ~mask[index]) | (1L << index);
        long p2 = dfs(index - 1, status);
        return memo[index][status] = Long.bitCount(p2) < Long.bitCount(p1) ? p2 : p1;
    }
}