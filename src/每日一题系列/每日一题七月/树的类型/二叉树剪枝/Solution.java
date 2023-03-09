package 每日一题系列.每日一题七月.树的类型.二叉树剪枝;

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;

        node1.left.left = node4;
        node1.left.right = node5;
        node1.right.left = node6;
        node1.right.right = node7;
        Solution solution = new Solution();
        solution.pruneTree(node1);
    }

    public TreeNode pruneTree(TreeNode root) {
       root= newRoot(root);
        return root;
    }
    private TreeNode newRoot(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = newRoot(root.left);
        root.right = newRoot(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
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
