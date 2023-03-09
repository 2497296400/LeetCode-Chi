package 每日一题系列.每日一题七月.树的类型.完全二叉树插入器;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

}

class CBTInserter {
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> fatherNode = new LinkedList<>();
        queue.add(root);
        int curLen = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            if (len < Math.pow(2, curLen - 1)) {
                 break;
            }
            while (len > 0) {
                TreeNode node = queue.poll();
                fatherNode.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                len--;
            }
            curLen++;
        }
        TreeNode addNode=new TreeNode(val);
        int ans=fatherNode.peek().val;
        while (!fatherNode.isEmpty()){
            TreeNode treeNode = fatherNode.poll();
            ans=treeNode.val;
            if(treeNode.left==null){
                treeNode.left=addNode;
                return ans;
            }
            if(treeNode.right==null){
                treeNode.right=addNode;
                return ans;
            }
        }
        return ans;
    }

    public TreeNode get_root() {
        return root;

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