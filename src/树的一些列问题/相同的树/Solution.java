package 树的一些列问题.相同的树;

public class Solution {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
//        TreeNode p4 = new TreeNode(1);
//        TreeNode p5 = new TreeNode(1);
//        TreeNode p6 = new TreeNode(1);
//        TreeNode p7 = new TreeNode(1);
//        TreeNode p8 = new TreeNode(1);
//        TreeNode p9 = new TreeNode(1);
        TreeNode p=new TreeNode();
        p1.left=p2;
        p1.right=p3;
        p=p1;
        TreeNode q=new TreeNode();
        q=p1;
        System.out.println(isSameTree(p,q));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
      if(p==null&&q==null){
          return true;
      }
      if(p==null||q==null||p.val!=q.val){
          return false;
      }
      return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    static class TreeNode {
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
}
