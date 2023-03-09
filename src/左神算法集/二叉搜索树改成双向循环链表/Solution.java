package 左神算法集.二叉搜索树改成双向循环链表;


public class Solution {
    public TreeNode getList(TreeNode root) {
        Info ans = fun(root);
        ans.end.right = ans.start;
        ans.start.left = ans.end;
        return ans.start;

    }

    private Info fun(TreeNode root) {
        if (root == null) {
            return new Info(null, null);
        }
        Info left = fun(root.left);
        Info right = fun(root.right);
        if (left.end != null) {
            left.end.right = root;
        }
        root.left = left.end;
        root.right = right.start;
        if (right.start != null) {
            right.start.left = root;
        }
        return new Info(left.start != null ? left.start : root, right.end != null ? right.end : root);
    }
}

class Info {
    TreeNode start;
    TreeNode end;

    public Info(TreeNode start, TreeNode end) {
        this.start = start;
        this.end = end;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
