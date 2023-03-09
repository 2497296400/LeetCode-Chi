package 每日一题系列.每日一题八月.树.在二叉树中增加一行;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution13 solution13=new Solution13();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        solution13.addOneRow(treeNode1, 1, 2);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            return new TreeNode(val,root,null);
        }
      fun(root,val,depth,1);
    return  root;

    }

    private void fun(TreeNode root, int val, int depth, int deep) {
        if(root==null){
            return;
        }
        if(deep==depth-1){
            TreeNode left=root.left;
            TreeNode right= root.right;
            root.left=new TreeNode(val,left,null);
            root.right=new TreeNode(val,null,right);
        }
        fun (root.left,val,depth,deep+1);
        fun(root.right,val,depth,deep+1);
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