package 树的一些列问题.二叉树的直径;

public class Solution {
    private int max = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);
        t1.left=t2;
        t2.right=t3;
        t4.left=t5;
        t3.left=t4;
        t1.right=t6;

        System.out.println(solution.diameterOfBinaryTree(t1));

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = 0;
        int rightSize = 0;
        if (root.left != null) {
            leftSize = dfs(root.left) ;
        }
        if (root.right != null) {
            rightSize = dfs(root.right) ;
        }
        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize)+1;
    }

    public Info fun(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = fun(root.left);
        Info rightInfo = fun(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxPath = Math.max(leftInfo.height + rightInfo.height, Math.max(leftInfo.maxPath, rightInfo.maxPath));
        return new Info(height, maxPath);
    }

    public static class Info {
        int height;
        int maxPath;

        public Info(int height, int maxPath) {
            this.height = height;
            this.maxPath = maxPath;
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