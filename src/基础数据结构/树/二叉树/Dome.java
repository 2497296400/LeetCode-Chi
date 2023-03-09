package 二叉树;

public class Dome {
    public static void main(String[] args) {
        int []root1={1,3,2,5};
        int []root2={2,1,3,0,4,0,7};
        TreeNode tree1= CreatTree.Tree(new TreeNode());
//        TreeNode tree2= CreatTree.Tree(new TreeNode());
//        Solution s=new Solution();
//        TreeNode tree3=s.mergeTrees(tree1,tree2);
//        System.out.println(tree3);
        Solution01 s=new Solution01();
        System.out.println(s.isValidBST(tree1));
    }
}
