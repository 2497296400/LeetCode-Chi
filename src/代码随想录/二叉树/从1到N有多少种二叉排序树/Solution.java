package 代码随想录.二叉树.从1到N有多少种二叉排序树;


import 力扣工具类.树的节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fun(1, n));
        list = new ArrayList<>();
        TreeNode head = new TreeNode();
        List<TreeNode> aLl = getALl(1, n);
        System.out.println(aLl.size());
    }

    static List<TreeNode> list;

    private static List<TreeNode> getALl(int left, int right) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (left > right) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = left; i <= right; i++) {
            TreeNode head = new TreeNode(i);
            List<TreeNode> leftList = getALl(left, i - 1);
            List<TreeNode> rightList = getALl(i + 1, right);
            for (TreeNode treeNode : leftList) {
                for (TreeNode node : rightList) {
                    head.left = treeNode;
                    head.right = node;
                    treeNodes.add(head);
                }
            }
        }
        return treeNodes;
    }

    private static int fun(int left, int right) {
        if (right == 0 || right == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= right; i++) {
            int leftNum = fun(left, i - 1);
            int rightNum = fun(i , right - i);
            ans += leftNum * rightNum;
        }
        return ans;
    }
}
