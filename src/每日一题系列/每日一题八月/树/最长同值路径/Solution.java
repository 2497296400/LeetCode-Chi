package 每日一题系列.每日一题八月.树.最长同值路径;

public class Solution {
    int curMax = 0;
    int curSum = 0;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(5);
        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t4.right=t7;
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(t1));
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        fun(root,0);
        return curMax;
    }

    private int fun(TreeNode root,int curLen) {
        if (root == null) {
            return 0;
        }
        int leftSum = fun(root.left,curLen+1);
        int rightSum = fun(root.right,curLen+1);
        int curLeft = 0;
        int curRight = 0;
        if (root.left != null && root.left.val == root.val) {
            System.out.println("left"+curLen);
            curLeft = leftSum + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            System.out.println("right"+curLen);
            curRight = rightSum + 1;
        }
        curMax = Math.max(curMax, curLeft + curRight);
        return Math.max(curLeft,curRight);
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