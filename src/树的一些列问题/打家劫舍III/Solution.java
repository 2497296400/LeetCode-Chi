package 树的一些列问题.打家劫舍III;

import java.util.*;

public class Solution {
    public HashMap<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode1.left.right=treeNode4;
        treeNode1.right.right=treeNode5;
        Solution solution = new Solution();
        System.out.println(solution.rob(treeNode1));


    }

    public int rob(TreeNode root) {
        return toGetMax(root);

    }

    private int toGetMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        //偷取当前节点
        int steelCur = 0;
        if (root.left != null) {
            steelCur += toGetMax(root.left.left) + toGetMax(root.left.right);
        }
        if (root.right != null) {
            steelCur += toGetMax(root.right.left) + toGetMax(root.right.right);
        }
        steelCur += root.val;
        //不偷当前节点

        int noSteelCur;
        noSteelCur = toGetMax(root.left) + toGetMax(root.right);
        map.put(root, Math.max(steelCur, noSteelCur));
        return map.get(root);
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