package 深度广度遍历问题.组合;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rns = new ArrayList<>();
        if (k <= 0 || n < k) {
            return rns;
        }
        Stack<Integer> path = new Stack<>();
        dfs(n, k, 1, path, rns);
        return  rns;
    }
    private void dfs(int n, int k, int begin, Stack<Integer> path, List<List<Integer>> rns) {
        if (path.size() == k) {
            rns.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin; i <=n-(k-path.size())+1;i++) {
            path.push(i);
            dfs(n, k, i+1, path, rns);
            path.pop();
        }
    }
}