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
        //    solution.preOrder(treeNode);
        // solution.inOrder(treeNode);
//        solution.postOrder(treeNode);
//        System.out.println("-------");
//        solution.postOrder2(treeNode);
        solution.hierarchicalTraversal(treeNode, 0);
        solution.deepList.forEach(System.out::println);
    }

    //迭代版前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            System.out.println(curNode.val);
        }
    }

    //迭代版中序遍历

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = root;
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

    //迭代后续遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVistit = null;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != lastVistit) {
                    curNode = peek.right;
                } else {
                    lastVistit = stack.pop();
                    System.out.println(lastVistit.val);
                }
            }
        }
    }

    //递归版后续遍历
    public void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> post = new ArrayList<>();
        TreeNode curNode = root;
        stack.push(curNode);
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            post.add(curNode.val);
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
        }
        Collections.reverse(post);
        System.out.println(post);
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
