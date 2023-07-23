package 代码随想录.二叉树.二叉搜索树的最小绝对差;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    TreeNode pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        fun(root);
        return res;
    }

    private void fun(TreeNode root) {
        if (root == null) return;
        fun(root.left);
        if (pre != null) {
            res = Math.min(res, Math.abs(pre.val - root.val));
        }
        pre = root;
        fun(root.right);
    }
}
