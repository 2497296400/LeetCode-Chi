package 周赛.三百一十一.反转二叉树的奇数层;

import 动态规划问题.解码方法.T;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(8);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(21);
        TreeNode t7 = new TreeNode(34);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(8);
        TreeNode t10 = new TreeNode(8);
        TreeNode t11 = new TreeNode(8);
        TreeNode t12 = new TreeNode(9);
        TreeNode t13 = new TreeNode(9);
        TreeNode t14 = new TreeNode(9);
        TreeNode t15 = new TreeNode(9);
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;
        Solution solution = new Solution();
        System.out.println(solution.reverseOddLevels(t1));
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode fun = fun(root);
        System.out.println(levelOrder(fun));
        return fun;

    }
    public  List<List<Integer>> levelOrder(TreeNode root) {
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

    private TreeNode fun(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (len % 2 != 0) {
                Deque<TreeNode> deque = new LinkedList<>(queue);
                toget(deque);
            }
            for (int i = 0; i < size; i++) {
                TreeNode curNode  = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            len++;
        }
        return root;
    }

    private void toget(Deque<TreeNode> deque) {
        while (!deque.isEmpty()) {
            TreeNode first = deque.pollFirst();
            TreeNode second = deque.pollLast();
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
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