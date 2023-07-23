package 代码随想录.二叉树.完全二叉树的节点个数;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = 0;
        int rightDeep = 0;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        while (leftNode != null) {
            leftDeep++;
            leftNode = leftNode.left;
        }
        while (rightNode != null) {
            rightDeep++;
            rightNode = rightNode.right;
        }
        if (leftDeep == rightDeep) {
            return (int) Math.pow(2, leftDeep + 1) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
