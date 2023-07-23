package 代码随想录.二叉树.二叉树最左边的节点值;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    int maxLen;
    int res;

    public int findBottomLeftValue(TreeNode root) {
        getLeftMaxLen(root, 0);
        return res;
    }

    private void getLeftMaxLen(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            if (maxLen < deep) {
                res = root.val;
                maxLen = deep;
            }
        }
        if (root.left != null) {
            getLeftMaxLen(root.left, deep + 1);
        }
        if (root.right != null) {
            getLeftMaxLen(root.right, deep + 1);
        }
    }
}
