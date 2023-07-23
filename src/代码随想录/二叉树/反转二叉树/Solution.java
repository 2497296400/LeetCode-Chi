package 代码随想录.二叉树.反转二叉树;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1, 2, 3, null, null, 4, 5});
        Solution solution = new Solution();
        LeetCodeUtils.treePrint(treeNode);
        solution.invertTheBinaryTree(treeNode);
        LeetCodeUtils.treePrint(treeNode);
        solution.invertTheBinaryTree2(treeNode);
        LeetCodeUtils.treePrint(treeNode);
    }

    //递归法
    public void invertTheBinaryTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        invertTheBinaryTree(treeNode.left);
        invertTheBinaryTree(treeNode.right);
    }

    //迭代法
    public void invertTheBinaryTree2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            TreeNode temp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = temp;
            if (curNode.left != null) {
                stack.add(curNode.left);
            }
            if (curNode.right != null) {
                stack.add(curNode.right);
            } 
        }
    }
}
