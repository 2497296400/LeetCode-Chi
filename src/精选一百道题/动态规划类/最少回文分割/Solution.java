package 精选一百道题.动态规划类.最少回文分割;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aasadasdsdaskd";
        System.out.println(solution.minCut(s));
    }

    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        boolean[][] map = new boolean[s.length()][s.length()];
        creatCM(map, chars);
        Arrays.fill(dp, -1);
        int ans = fun(chars, 0, dp, map) - 1;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0, j = 1; j <= chars.length; j++) {
            if (map[i][j - 1] && dp[i] == dp[j] + 1) {
                arrayList.add(s.substring(i, j));
                i = j;
            }
        }
        System.out.println(arrayList);
        ArrayList<ArrayList<String>> allAns = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        toGetAll(s, dp, map, allAns, path, 0, 1);
        System.out.println(allAns);
        return ans;
    }

    private void toGetAll(String chars, int[] dp, boolean[][] map, ArrayList<ArrayList<String>> allAns, ArrayList<String> path, int i, int j) {
        if (j == chars.length()) {
            path.add(chars.substring(i, j));
            allAns.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        } else {
            if (map[i][j - 1] && dp[i] == dp[j] + 1) {
                path.add(chars.substring(i, j));
                toGetAll(chars, dp, map, allAns, path, j, j + 1);
                path.remove(path.size() - 1);
            } else {
                toGetAll(chars, dp, map, allAns, path, i, j + 1);
            }
        }
    }

    private void creatCM(boolean[][] map, char[] chars) {
        for (int i = 0; i < map.length - 1; i++) {
            map[i][i] = true;
            map[i][i + 1] = chars[i] == chars[i + 1];
        }
        map[chars.length - 1][chars.length - 1] = true;
        for (int i = chars.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < chars.length; j++) {
                map[i][j] = chars[i] == chars[j] && map[i + 1][j - 1];
            }
        }
    }

    private int fun(char[] chars, int cur, int[] dp, boolean[][] map) {
        if (cur == chars.length) {
            dp[cur] = 0;
            return 0;
        }
        if (dp[cur] != -1) {
            return dp[cur];
        }
        int next = Integer.MAX_VALUE;
        for (int end = cur; end < chars.length; end++) {
            if (map[cur][end]) {
                next = Math.min(next, fun(chars, end + 1, dp, map));
            }
        }
        dp[cur] = next + 1;
        return next + 1;
    }
}