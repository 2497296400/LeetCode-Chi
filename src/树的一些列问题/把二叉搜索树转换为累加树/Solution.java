package 树的一些列问题.把二叉搜索树转换为累加树;

public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
      if(root!=null){
          convertBST(root.right);
          root.val+=sum;
          sum=root.val;
          convertBST(root.left);
          return root;
      }
      return null;
    }
}
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }