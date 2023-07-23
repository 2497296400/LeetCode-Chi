package 代码随想录.二叉树.对称二叉树;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(new Solution().isSymmetrc(treeNode));
    }

    public boolean isSymmetry(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        return isSymmetry(treeNode.left, treeNode.right);
    }

    private boolean isSymmetry(TreeNode f, TreeNode s) {
        if (f == null && s == null) {
            return true;
        } else if (f == null || s == null) {
            return false;
        }
        if (f.val != s.val) {
            return false;
        }
        return isSymmetry(f.left, s.right) && isSymmetry(f.right, s.left);
    }

    //迭代
    public boolean isSymmetrc(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode.left);
        queue.add(treeNode.right);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null||(first.val!=second.val)) {
                return false;
            }
            queue.add(first.left);
            queue.add(second.right);
            queue.add(first.right);
            queue.add(second.left);
        }
        return true;
    }
}
