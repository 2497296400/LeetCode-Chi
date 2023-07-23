package 代码随想录.二叉树.验证二叉搜索树;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }
}
