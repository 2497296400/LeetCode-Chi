package 周赛.三百一十七.移除子树后的二叉树高度;

import java.util.*;

class Solution {
    private Map<TreeNode, Integer> height = new HashMap<>(); // 每棵子树的高度
    private int[] res; // 每个节点的答案

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t3;
        t3.left = t2;
        t1.right = t4;
        t4.right = t5;
        t4.left = t6;
        t5.right = t7;
        System.out.println(Arrays.toString(solution.treeQueries(t1, new int[]{4})));
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        deep(root);
        int[] ans = new int[queries.length];
        height.put(null, 0);
        res = new int[height.size()];
        dfs(root, -1, 0);
        int len = 0;
        for (int query : queries) {
            ans[len++] = res[query];
        }
        return ans;
    }

    private void dfs(TreeNode root, int deep, int maxH) {
        if (root == null) {
            return;
        }
        res[root.val] = maxH;
        dfs(root.left, deep+1, Math.max(maxH, deep+1 + height.get(root.right)));
        dfs(root.right, deep+1, Math.max(maxH, deep +1+ height.get(root.left)));
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curDeep = Math.max(deep(root.left), deep(root.right)) + 1;
        height.put(root, curDeep);
        return curDeep;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
