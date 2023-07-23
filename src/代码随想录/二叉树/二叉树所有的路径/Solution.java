package 代码随想录.二叉树.二叉树所有的路径;

import 力扣工具类.树的节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        getBinaryTree(root, ans, "");
        return ans;
    }

    private void getBinaryTree(TreeNode root, List<String> ans, String curTemp) {
        if (root.left == null && root.right == null) {
            ans.add(curTemp);
            return;
        }
        if (curTemp.equals("")) {
            curTemp = String.valueOf(root.val);
        } else {
            curTemp += "->" + root.val;
        }
        if (root.left != null) {
            getBinaryTree(root.left, ans, curTemp);
        }
        if (root.right != null) {
            getBinaryTree(root.right, ans, curTemp);
        }
    }
}
