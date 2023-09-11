package 代码随想录.二叉树.二叉树的遍历;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1, 2, 3, null, null, 4, 5});
        Solution solution = new Solution();
        solution.preOrder(treeNode);
        solution.inorder(treeNode);
        solution.postOrder(treeNode);
        solution.inOrder2(treeNode);
        System.out.println("-------");
        solution.hierarchicalTraversal(treeNode, 0);
        solution.deepList.forEach(System.out::println);
    }

    public void preOrder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(curNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
    }

    public void inOrder2(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        inorder(curNode.left);
        System.out.println(curNode.val);
        inorder(curNode.right);
    }

    public void postOrder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(curNode);
        List<Integer> post = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            post.add(pop.val);
            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        Collections.reverse(post);
        System.out.println(post);
    }

    public void inorder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = curNode;

        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                curNode = pop.right;
            }
        }
    }

    List<List<Integer>> deepList = new ArrayList<>();

    //层次遍历
    public void hierarchicalTraversal(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (deepList.size() < deep) {
            List<Integer> curDeepList = new ArrayList<>();
            deepList.add(curDeepList);
        }
        deepList.get(deep - 1).add(root.val);
        hierarchicalTraversal(root.left, deep);
        hierarchicalTraversal(root.right, deep);
    }
}
