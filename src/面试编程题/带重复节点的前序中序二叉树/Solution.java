package 面试编程题.带重复节点的前序中序二叉树;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<TreeNode> trees = solution.getBinaryTrees(List.of(1, 3, 4, 1, 3, 3, 1), List.of(1, 3, 4, 3, 1, 1, 3));
        for (TreeNode tree : trees) {
            System.out.println("============================");
            LeetCodeUtils.treePrint(tree);
            System.out.println("============================");
        }
    }

    public ArrayList<TreeNode> getBinaryTrees(List<Integer> preOrder, List<Integer> inOrder) {
        int r = preOrder.size() - 1;

        return fun(preOrder, 0, r, inOrder, 0, r);
    }


    private ArrayList<TreeNode> fun(List<Integer> preOrder, int preL, int preR, List<Integer> inOrder, int il, int ir) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (preL > preR ) {
            ans.add(null);
            return ans;
        }
        TreeNode newNode = new TreeNode(preOrder.get(preL));
        for (int i = il; i <= ir; i++) {
            if (inOrder.get(i) == newNode.val) {
                int leftSize = i - il;
                ArrayList<TreeNode> left = fun(preOrder, preL + 1, preL + leftSize, inOrder, il, i - 1);
                ArrayList<TreeNode> right = fun(preOrder, leftSize + 1 + preL, preR, inOrder, i + 1, ir);
                for (TreeNode treeNode : left) {
                    for (TreeNode node : right) {
                        TreeNode curNode = new TreeNode(newNode.val);
                        curNode.left = treeNode;
                        curNode.right = node;
                        ans.add(curNode);
                    }
                }
            }
        }
        return ans;
    }
}