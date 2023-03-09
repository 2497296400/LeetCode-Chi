package 树的一些列问题.二叉树的层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node.left.left = node3;
        node.left.right = node4;
        System.out.println(levelOrder(node));


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        queue1.add(root);
        List<Integer> list1 = new ArrayList<>();
        while (true) {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                break;
            }
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }
            list1.add(node.val);
            if (queue1.isEmpty()) {
                queue1.addAll(queue2);
                list.add(new ArrayList<>(list1));
                list1 = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    queue2.poll();
                }
            }
        }
        return list;
    }
}
