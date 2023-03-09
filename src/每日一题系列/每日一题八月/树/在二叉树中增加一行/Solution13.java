package 每日一题系列.每日一题八月.树.在二叉树中增加一行;

public class Solution13 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            return new TreeNode(val,root,null);
        }
        fun(root,val,depth,true,1);
        return root;

    }

    private TreeNode fun(TreeNode root, int val, int depth, boolean isLeft, int deep) {
        if(root==null&&depth!=deep){
            return  null;
        }
        if (root!=null) {
            root.left  = fun(root.left, val, depth, true, deep + 1);
            root.right= fun(root.right, val, depth, false, deep + 1);}
        if(deep==depth){
                if(isLeft){
                    return new TreeNode(val,root,null);
                }else {
                    return new TreeNode(val,null,root);
                }
        }
        return root;
    }
}
