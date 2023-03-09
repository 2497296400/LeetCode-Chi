package 每日一题系列.每日一题八月.树.二叉树的最大宽度;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

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
        t2.left = t4;
        t4.left = t7;
        t3.right = t6;
        t6.left = t5;
        solution.widthOfBinaryTree(t1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, Deque<TreeNode>> map = new HashMap<>();
        int curMax = 0;
        int curLen = 1;
        queue.add(root);
        Deque<Integer> index = new LinkedList<>();
        index.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int curIndex=index.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    index.add(curIndex*2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    index.add(curIndex*2+1);
                }
            }
            if(index.size()>1){
                int first=index.peekFirst();
                int last=index.peekLast();
                 curMax=Math.max(curMax, last-first+1);
            }
        }
        return curMax;
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