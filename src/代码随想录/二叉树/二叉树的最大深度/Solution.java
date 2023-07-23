package 代码随想录.二叉树.二叉树的最大深度;

import 力扣工具类.树的节点.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
}
