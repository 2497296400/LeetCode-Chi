package 代码随想录.二叉树.路径总和;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    int deep = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, deep);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int deep) {
        int cur = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return cur == 0;
        }
        boolean l = false, r = false;
        if (root.left != null) {
            l = hasPathSum(root.left, cur, deep);
        }
        if (root.right != null) {
            r = hasPathSum(root.right, cur, deep);
        }
        return l || r;
    }
}
