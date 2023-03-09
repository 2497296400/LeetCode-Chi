package 每日一题系列.每日一题七月.树的类型.完全二叉树插入器;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

}

class CBTInserter2 {
    TreeNode root;
    Queue<TreeNode>fatherNode;
    public CBTInserter2(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        fatherNode=new LinkedList<>();
        this.root=root;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(node.left==null||node.right==null){
                fatherNode.add(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode addNode=new TreeNode(val);
        TreeNode node = fatherNode.peek();
        int ans=node.val;
        if(node.left==null){
            node.left=addNode;
        }
        if(node.right==null){
            node.right=addNode;
            fatherNode.poll();
        }
        fatherNode.add(addNode);
        return ans;

    }

    public TreeNode get_root() {
        return root;
    }
}