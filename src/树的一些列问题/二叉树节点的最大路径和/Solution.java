package 树的一些列问题.二叉树节点的最大路径和;

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

public class Solution {
    public static int maxPath = Integer.MIN_VALUE;
    int curMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(-1);
//        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(15);
//        TreeNode node4 = new TreeNode(7);
//        node.left = node1;
//        node.right = node2;
//        node.right.left = node3;
//        node.right.right = node4;
        node.left = node1;
    }

    public static int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPath;
    }

    private static int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxPath = Math.max(maxPath(root.left), 0);
        int rightMaxPath = Math.max(maxPath(root.right), 0);
        maxPath = Math.max(maxPath, leftMaxPath + rightMaxPath + root.val);
        return Math.max(leftMaxPath, rightMaxPath) + root.val;
    }

    public int fun(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = fun(root.left);
        int right = fun(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        curMax=Math.max(curMax, left+right+root.val);
        return Math.max(left, right);
    }
}




