package 周赛.三百零七.感染二叉树需要的总时间;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8= new TreeNode(2);
         node1.left=node2;
         node1.right=node3;
         node2.right=node4;
         node3.left=node5;
         node3.right=node6;
         node4.left=node7;
         node4.right=node8;
        Solution solution = new Solution();
        System.out.println(solution.amountOfTime(node1, 3));
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        HashMap<TreeNode, Boolean> curMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode startNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode curNode = queue.poll();
                if (curNode.val == start) {
                    startNode = curNode;
                    curMap.put(curNode, true);
                } else {
                    curMap.put(curNode, false);
                }
                if (curNode.left != null) {
                    fatherMap.put(curNode.left, curNode);
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    fatherMap.put(curNode.right, curNode);
                    queue.add(curNode.right);
                }
            }
        }
        queue.add(startNode);
        int sum = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode curNode = queue.poll();
                if (curNode.left != null && !curMap.get(curNode.left)) {
                    curMap.put(curNode.left, true);
                    queue.add(curNode.left);
                }
                if (curNode.right != null && !curMap.get(curNode.right)) {
                    curMap.put(curNode.right, true);
                    queue.add(curNode.right);
                }
                if (fatherMap.containsKey(curNode)&&!curMap.get(fatherMap.get(curNode))) {
                    queue.add(fatherMap.get(curNode));
                    curMap.put(fatherMap.get(curNode), true);
                }
            }
            sum++;
        }
        return sum;
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