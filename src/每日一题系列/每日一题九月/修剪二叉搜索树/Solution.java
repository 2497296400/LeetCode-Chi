package 每日一题系列.每日一题九月.修剪二叉搜索树;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        t4.left = t2;
        t2.right = t3;
        t4.right = t5;
        Solution solution = new Solution();
        solution.trimBST(t4, 3, 4);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, low, high);
        if (root.val < low) {
            //递归寻找下一个符合条件的节点
            TreeNode right = trimBST(root.right, low, high);
            return right;
        } else if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.right = trimBST(root.right, low, high);
        return root;

    }

    public static class Info {
        int left;
        int right;

        public Info(int left, int right) {
            this.left = left;
            this.right = right;
        }
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