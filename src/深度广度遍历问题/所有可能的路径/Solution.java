package 深度广度遍历问题.所有可能的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = new Solution().allPathsSourceTarget(graph);
        System.out.println(lists);
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = 0;
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        DFS(0, graph, lists, list);
        return lists;
    }

    private void DFS(int x, int[][] graph, List<List<Integer>> lists, List<Integer> list) {
        if (x == graph.length - 1) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < graph[x].length; i++) {
            list.add(graph[x][i]);
            DFS(graph[x][i], graph, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
