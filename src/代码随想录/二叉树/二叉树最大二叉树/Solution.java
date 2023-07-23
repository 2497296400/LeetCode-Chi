package 代码随想录.二叉树.二叉树最大二叉树;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 6, 0, 5};
        LeetCodeUtils.treePrint(solution.constructMaximumBinaryTree(nums));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int curMax = -1;
        int index = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
                index = i;
            }
        }
        //System.out.println(curMax);
        TreeNode treeNode = new TreeNode(curMax);
        treeNode.left = constructMaximumBinaryTree(nums, l, index - 1);
        treeNode.right = constructMaximumBinaryTree(nums, index + 1, r);
        return treeNode;
    }
}
