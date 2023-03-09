package 树的一些列问题.二叉树的反序列化;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.right = t5;
        t3.left = t4;
        Queue<String> queue = new LinkedList<>();
        solution.preCodec(t1, queue);
        System.out.println(queue);
        solution.pre(t1);
        System.out.println("----");
        TreeNode treeNode = solution.fanPre(queue);
        solution.pre(treeNode);
        System.out.println("-----");
        Queue<String> cur = new LinkedList<>();
        solution.levelCodec(t1, cur);
        TreeNode treeNode1 = solution.fanLevel(cur);
        solution.pre(treeNode1);
    }

    public void preCodec(TreeNode root, Queue<String> queue) {
        if (root == null) {
            queue.add(null);
        } else {
            queue.add(String.valueOf(root.val));
            preCodec(root.left, queue);
            preCodec(root.right, queue);
        }
    }

    public void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        pre(treeNode.left);
        pre(treeNode.right);
    }

    public TreeNode fanPre(Queue<String> queue) {
        if (queue.peek() == null) {
            queue.poll();
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(queue.poll()));
        newNode.left = fanPre(queue);
        newNode.right = fanPre(queue);
        return newNode;
    }

    public void levelCodec(TreeNode root, Queue<String> queue) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            if (curNode == null) {
                queue.add(null);
            } else {
                queue.add(String.valueOf(curNode.val));
                nodeQueue.add(curNode.left);
                nodeQueue.add(curNode.right);
            }
        }
    }

    public TreeNode fanLevel(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(queue.poll()));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(head);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            curNode.left = funNode(queue.poll());
            curNode.right = funNode(queue.poll());
            if (curNode.left != null) {
                nodeQueue.add(curNode.left);
            }
            if (curNode.right != null) {
                nodeQueue.add(curNode.right);
            }
        }
        return head;
    }

    private TreeNode funNode(String poll) {
        if (poll == null) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(poll));
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}