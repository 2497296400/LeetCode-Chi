package 树的一些列问题.最大搜索二叉树;

public class Solution {
    public Info process(TreeNode head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int curTreeSize = 1;
        int maxBSTSize;
        int max = head.val;
        int min = head.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            curTreeSize += leftInfo.curTreeSize;
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            curTreeSize += rightInfo.curTreeSize;
        }
        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxBSTSize;

        }
        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxBSTSize;
        }
        boolean isLeftBST = leftInfo == null || (leftInfo.curTreeSize == leftInfo.maxBSTSize);
        boolean isRightBST = rightInfo == null || (rightInfo.curTreeSize == rightInfo.maxBSTSize);
        int p3 = -1;
        if (isLeftBST && isRightBST) {
            boolean leftMaxLess = leftInfo == null || (leftInfo.max < head.val);
            boolean rightMinLess = rightInfo == null || (rightInfo.min > head.val);
            if(leftMaxLess&&rightMinLess){
                int leftSize=leftInfo==null?0: leftInfo.curTreeSize;
                int right=rightInfo==null?0:rightInfo.curTreeSize;
                p3=leftSize+right+1;
            }
        }
        maxBSTSize=Math.max(p1,Math.max(p2, p3));
        return new Info(curTreeSize, maxBSTSize, max, min);
    }

    public static class Info {
        int curTreeSize;
        int maxBSTSize;
        int max;
        int min;

        public Info(int curTreeSize, int maxBSTSize, int max, int min) {
            this.curTreeSize = curTreeSize;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
        }
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
