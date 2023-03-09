package 每日一题系列.每日一题八月.树.输出二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);

        TreeNode root3 = new TreeNode(5);

        TreeNode root4 = new TreeNode(3);

        TreeNode root5 = new TreeNode(4);
        root1.left = root2;

        root1.right = root3;

        root2.left = root4;
        root4.left = root5;
        System.out.println(solution.printTree(root1));
    }

    public List<List<String>> printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            len++;
        }
        int m = len;
        int n = (int) (Math.pow(2, len) - 1);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> curList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                curList.add("");
            }
            list.add(curList);
        }

        queue.add(root);
        list.get(0).set((n - 1) / 2, String.valueOf(root.val));
        len = 1;
        int c = (n - 1) / 2;
        Queue<Integer> qc = new LinkedList<>();
        qc.add(c);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                c = qc.poll();
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                    list.get(len).set(c - (int) Math.pow(2, m - len - 1), String.valueOf(node.left.val));
                    qc.add(c - (int) Math.pow(2, m - len - 1));
                }
                if (node.right != null) {
                    queue.add(node.right);
                    list.get(len).set(c + (int) Math.pow(2, m - len - 1), String.valueOf(node.right.val));
                    qc.add(c + (int) Math.pow(2, m - len - 1));
                }
            }
            len++;
        }
        return list;
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