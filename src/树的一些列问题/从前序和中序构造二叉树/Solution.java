package 树的一些列问题.从前序和中序构造二叉树;

import java.util.HashMap;

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

public class Solution {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preorder.length < 1) {
            return new TreeNode();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, hashMap, 0, inLen - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRinght, HashMap<Integer, Integer> hashMap, int inLeft, int inRight) {
        if (preRinght < preLeft || inRight < inLeft) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        int rootIndex = hashMap.get(node.val);
        node.left = buildTree(preorder, preLeft + 1, rootIndex - inLeft + preLeft, hashMap, inLeft, rootIndex - 1);
        node.right = buildTree(preorder, rootIndex - inLeft + preLeft + 1, preRinght, hashMap, rootIndex + 1, inRight);
        return  node;
    }
}
