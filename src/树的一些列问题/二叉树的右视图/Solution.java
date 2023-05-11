package 树的一些列问题.二叉树的右视图;

import 力扣工具类.树的节点.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();

        getRight(root, 0);
        return ans;

    }

    private void getRight(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (ans.size() == deep) {
            ans.add(root.val);
        }
        getRight(root.right, deep + 1);
        getRight(root.left, deep + 1);
    }
}
