package 代码随想录.二叉树.从中序和后序构造二叉树;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
        LeetCodeUtils.treePrint(solution.buildTree(in, post));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorderMap, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(HashMap<Integer, Integer> inorderMap, int il, int ir, int[] postorder, int pl, int pr) {
        if (pl > pr) {
            return null;
        }
        int crossLine = inorderMap.get(postorder[pr]);
        TreeNode treeNode = new TreeNode(postorder[pr]);
        int leftSize = crossLine - il;
        int rightSize = ir - crossLine;
      //  System.out.println(leftSize + "---" + crossLine + "---" + rightSize);
        treeNode.left = buildTree(inorderMap, il, crossLine - 1, postorder, pl, pl + leftSize - 1);
        treeNode.right = buildTree(inorderMap, crossLine + 1, ir, postorder, pr - rightSize, pr - 1);
        return treeNode;
    }
}
