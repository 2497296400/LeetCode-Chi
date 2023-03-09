package s;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private boolean cmp(TreeNode Node1, TreeNode Node2) {
        if (Node1 == null && Node2 == null) {
            return true;
        }
        if (Node1 == null || Node2 == null || Node1.val != Node2.val) {
            return false;
        }
        return cmp(Node1.left, Node2.right) && cmp(Node2.left, Node1.right);
    }
    //迭代
    private boolean isSymmetric1(TreeNode treeNode){
        if(treeNode==null){
            return true;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(treeNode.left);
        queue.add(treeNode.right);
        while (!queue.isEmpty()){
            TreeNode node1=queue.poll();
            TreeNode node2=queue.poll();
            if(node1==null&&node2==null){
                continue;
            }
            if(node1==null||node2==null||node1.val!=node2.val){
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;

    }
}
