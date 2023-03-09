package 深度广度遍历问题.另一颗子树;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode subRoot = new TreeNode(4);
        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(2);
        TreeNode l4 = new TreeNode(1);
        TreeNode l5 = new TreeNode(2);
        root.left=l1;
        root.left.left=l2;
        root.left.right=l3;
        subRoot.left=l4;
        subRoot.right=l5;
        System.out.println( new Solution().isSubtree(root,subRoot));

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return DFS(root, subRoot);

    }

    private boolean DFS(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || DFS(root.left, subRoot) || DFS(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
