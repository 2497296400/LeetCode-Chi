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

    private TreeNode buildTree(HashMap<Integer, Integer> inorderMap, int il, int ir, int[] postorder, int hl, int hr) {
        if (hl > hr) {
            return null;
        }
        
        int curIndex = inorderMap.get(postorder[hr]);
        TreeNode newNode = new TreeNode(postorder[hr]);
        int leftSize = curIndex - il;
        int rightSize = ir - curIndex;
        
        newNode.left = buildTree(inorderMap, il, curIndex - 1, postorder, hl, hl + leftSize-1);
        newNode.right = buildTree(inorderMap, curIndex + 1, ir, postorder, hr -rightSize, hr - 1);
        return newNode;
    }
}
