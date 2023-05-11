package 树的一些列问题.二叉树的遍历方式;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Solution solution = new Solution();
        solution.preOreder(treeNode);
        solution.inOrder(treeNode);
        solution.posOrder(treeNode);
    }
    public void inOrder(TreeNode root) {
        System.out.println("InOrder ");
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.add(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.val+" ");
                    root = root.right;
                }
            }
        }
        System.out.println("===============");
    }

    public void preOreder(TreeNode root) {
        System.out.println("PreOreder");
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val+" ");
                if (root.right != null) {
                    stack.add(root.right);
                }
                if (root.left != null) {
                    stack.add(root.left);
                }
            }
        }
        System.out.println("===============");
    }

    public void posOrder(TreeNode root) {
        System.out.println("posOrder ");
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root != null) {
            s1.add(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.push(root);
                if (root.left != null) {
                    s1.push(root.left);
                }
                if (root.right != null) {
                    s1.push(root.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().val+" ");
            }
        }
        System.out.println("===============");
    }
}
