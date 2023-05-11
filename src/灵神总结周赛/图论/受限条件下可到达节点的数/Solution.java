package 灵神总结周赛.图论.受限条件下可到达节点的数;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;

import java.util.*;

public class Solution {
    int ans = 1;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = LeetCodeUtils.getIntTow("[[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]]");
        int[] r = {4, 2, 1};
        System.out.println(solution.reachableNodes(7, g, r));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
    /*    List<Integer>[] g = new List[n];
        Arrays.setAll(g, ArrayList<Integer>::new);*/
        for (int[] edge : edges) {
            int f = edge[0];
            int s = edge[1];
            if (map.containsKey(f)) {
                map.get(f).add(s);
            } else {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(s);
                map.put(f, value);
            }
            if (map.containsKey(s)) {
                map.get(s).add(f);
            } else {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(f);
                map.put(s, value);
            }
        }
        boolean[] vis = new boolean[n];
        for (int i : restricted) {
            vis[i] = true;
        }
        vis[0] = true;
        dfs(map, 0, vis);
        return ans;
    }

    private void dfs(HashMap<Integer, List<Integer>> g, int cur, boolean[] set) {
        for (Integer next : g.get(cur)) {
            if (next != cur && !set[next]) {
                ans++;
                set[next] = true;
                dfs(g, next, set);
            }
        }
    }
}