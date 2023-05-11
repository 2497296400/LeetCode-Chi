package 每日一题系列.每日一题四月.节点与其祖先之间的最大差值;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1, null, 2, null, 0, 3});
        System.out.println(solution.maxAncestorDiff(treeNode));
    }

    public int maxAncestorDiff(TreeNode root) {
        int maxLeft = fun(root.left, root.val, root.val);
        int maxRight = fun(root.right, root.val, root.val);
        // System.out.println(root.val);
        return Math.max(maxLeft, maxRight);
    }

    private int fun(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if (root.right == null && root.left == null) {
            return max - min;
        }
      //  System.out.println(max + " " + min);
        int left = fun(root.left, max, min);
        int right = fun(root.right, max, min);
        //    System.out.println(left + " " + right);

        return Math.max(left, right);
    }
}