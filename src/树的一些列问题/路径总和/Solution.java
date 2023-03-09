package 树的一些列问题.路径总和;

public class Solution {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(node,1));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;

        }
        return  getAns(root,targetSum-root.val);
    }

    private boolean getAns(TreeNode root, int curSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && curSum == 0) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = getAns(root.left, curSum - root.left.val);
        }
        if (root.right != null) {
            right = getAns(root.right, curSum - root.right.val);
        }
        return  right||left;
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