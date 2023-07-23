package 代码随想录.二叉树.二叉树的左叶子节点的累加值;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.right == null && root.left.left == null) {
            return leftSum + rightSum + root.left.val;
        }
        return leftSum + rightSum;
    }
}
