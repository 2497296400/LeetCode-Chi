package 团队赛.装饰树;

import 动态规划问题.解码方法.T;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        solution.expandBinaryTree(t1);

    }

    public TreeNode expandBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, TreeNode> father = new HashMap<>();
        while (!queue.isEmpty()) {
            int len = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                    father.put(curNode.left, curNode);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                    father.put(curNode.right, curNode);
                }
            }
        }
        for (Map.Entry<TreeNode, TreeNode> entry : father.entrySet()) {
            TreeNode curNode = entry.getKey();
            TreeNode fatherNode = entry.getValue();
            TreeNode newNode = new TreeNode(-1);
            if (fatherNode.left == curNode) {
                newNode.left = curNode;
                fatherNode.left = newNode;
            } else {
                newNode.right = curNode;
                fatherNode.right = newNode;
            }
        }
        return root;
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