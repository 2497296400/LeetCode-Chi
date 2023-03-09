package 树的一些列问题.监控二叉树;

public class Solution {
    public int minCameraCover(TreeNode root) {
        Info info = process(root);
        return (int) Math.min(info.unc + 1, Math.min(info.chas, info.cno));

    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        long noc = left.cno + right.cno;

        long cno = Math.min(left.chas + right.chas,
                Math.min(left.chas + right.cno,
                        left.cno + right.chas));

        long chas = Math.min(left.unc, Math.min(left.cno, left.chas)) +
                Math.min(right.unc, Math.min(right.chas, right.cno)) + 1;

        return new Info(noc, chas, cno);

    }
}

class Info {
    long unc;
    long chas;
    long cno;

    public Info(long unc, long chas, long cno) {
        this.unc = unc;
        this.chas = chas;
        this.cno = cno;
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