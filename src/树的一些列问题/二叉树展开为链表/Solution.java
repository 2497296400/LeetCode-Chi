package 树的一些列问题.二叉树展开为链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node.left = node1;
        node.left.left = node2;
        node.left.right = node3;
        node.right = node4;
        node.right.left = null;
        node.right.right = node5;
        flatten(node);


    }

    public static void flatten(TreeNode root) {
        TreeNode node = new TreeNode();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        for(int i=0;i<list.size()-1;i++){
            TreeNode pre=list.get(i), curr=list.get(i+1);
            pre.left=null;
            pre.right=curr;
        }
        System.out.println(root);
    }

}
