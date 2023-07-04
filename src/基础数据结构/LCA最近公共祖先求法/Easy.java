package 基础数据结构.LCA最近公共祖先求法;

import 力扣工具类.树的节点.TreeNode;

public class Easy {
    public TreeNode CommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        if (r == null || r == p || r == q) return r;
        TreeNode left = CommonAncestor(r.left, p, q);
        TreeNode right = CommonAncestor(r.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return r;
    }
}
