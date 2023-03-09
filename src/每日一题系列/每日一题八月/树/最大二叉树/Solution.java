package 每日一题系列.每日一题八月.树.最大二叉树;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node;
        node = fun( nums, 0, nums.length - 1);
        return node;
    }

    private TreeNode fun(int[] nums, int left, int right) {
        int curMax = Integer.MIN_VALUE;
        int curIndex = left;
        if (left > right) {
            return null;
        }
        for (int i = left; i <= right; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
                curIndex = i;
            }
        }
        TreeNode newNode = new TreeNode(nums[curIndex]);
        newNode.left = fun(nums, left, curIndex - 1);
        newNode.right = fun(nums, curIndex + 1, right);
        return newNode;
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