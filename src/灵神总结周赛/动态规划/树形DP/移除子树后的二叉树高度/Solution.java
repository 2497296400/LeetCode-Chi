package 灵神总结周赛.动态规划.树形DP.移除子树后的二叉树高度;

import 力扣工具类.树的节点.TreeNode;

import java.util.HashMap;

public class Solution {
    HashMap<TreeNode, Integer> heigh = new HashMap<>();
    int[] res;

    public int[] treeQueries(TreeNode root, int[] queries) {
        getHeight(root);
        heigh.put(null, 0);
        res = new int[heigh.size()];
        dfs(root, -1, 0);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = res[queries[i]];
        }
        return queries;
    }

    private void dfs(TreeNode root, int depth, int restH) {
        if (root == null) {
            return;
        }
        depth++;
        res[root.val] = restH;
        dfs(root.left, depth, Math.max(restH, depth + heigh.get(root.right)));
        dfs(root.right, depth, Math.max(restH, depth + heigh.get(root.left)));
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left) + 1;
        int r = getHeight(root.right) + 1;
        int curMax = Math.max(l, r);
        heigh.put(root, curMax);
        return curMax;
    }
}
