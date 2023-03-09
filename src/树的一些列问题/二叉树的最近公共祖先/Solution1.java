package 树的一些列问题.二叉树的最近公共祖先;

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return  getHeavier(root,p,q);

    }
    private TreeNode getHeavier(TreeNode root, TreeNode  p, TreeNode  q) {
        if(root==null||root==p||root==q){
            return root;
        }

        TreeNode leftNode=getHeavier(root.left,p,q);

        TreeNode rightNode=getHeavier(root.right,p,q);

        if(leftNode==null){
            return rightNode;
        }
        if(rightNode==null){
            return leftNode;
        }
        return root;
    }
}
