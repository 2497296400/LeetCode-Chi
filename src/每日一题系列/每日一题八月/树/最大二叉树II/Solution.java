package 每日一题系列.每日一题八月.树.最大二叉树II;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t4.left=t3;
        t3.left=t2;
        Solution solution = new Solution();
    solution.insertIntoMaxTree(t4, 1);
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            TreeNode curNode = new TreeNode(val);
            curNode.left=root;
            return curNode;
        }else{
            root.right=insertIntoMaxTree(root.right, val);
        }
        return root;
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