package 树的一些列问题.路径总和III;

public class Solution {
    int curSum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        getSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return curSum;
    }
    private void getSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum-=root.val;
        if (targetSum == 0) {
            curSum++;
        }
        getSum(root.left, targetSum);
        getSum(root.right, targetSum );
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