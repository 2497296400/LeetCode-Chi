package 代码随想录.二叉树.从前序和中序构建二叉树;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p = {3, 9, 20, 15, 7};
        int[] i = {9, 3, 15, 20, 7};
        LeetCodeUtils.treePrint(solution.buildTree(p, i));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorder, inorderMap, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, HashMap<Integer, Integer> inorderMap, int il, int ir, int[] preorder, int pl, int pr) {
        if (pl > pr) {
            return null;
        }
        int cline = 0;
        for (int strat = il; strat <= ir; strat++) {
            if (inorder[strat] == preorder[pl]) {
                cline = strat;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(preorder[pl]);
        int leftSize = cline - il;
        int rightSize = ir - cline;

        treeNode.left = buildTree(inorder, inorderMap, il, cline - 1, preorder, pl + 1, pl + leftSize);
        treeNode.right = buildTree(inorder, inorderMap, cline + 1, ir, preorder, pr - rightSize + 1, pr);
        return treeNode;
    }
}
