package 每日一题系列.每日一题八月.树.层数最深叶子节点的和;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int curSum = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                curSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            stack.add(curSum);
        }
        return stack.peek();
    }
    int max=0;
    HashMap<Integer, Integer>map=new HashMap<>();
    public void DFS(TreeNode root, int depth) {
        if(root==null){
            return;
        }
        max=Math.max(max, depth);
        map.put(depth, map.getOrDefault(depth, 0)+root.val);
        DFS(root.left, depth+1);
        DFS(root.right,depth+1);
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