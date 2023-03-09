package 基础数据结构.LCA最近公共祖先求法;

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