package 树的一些列问题.二叉树的最近公共祖先;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(6);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(0);
        TreeNode node7=new TreeNode(8);
        TreeNode node9=new TreeNode(7);
        TreeNode node10=new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node5.left=node9;
        node5.right=node10;
        solution.lowestCommonAncestor(node1,node2,node10);
        Solution1 solution1 = new Solution1();
        TreeNode treeNode = solution1.lowestCommonAncestor(node1, node2, node10);
        System.out.println(treeNode.val);
    }
    public List<TreeNode> P=new ArrayList<>();
    public List<TreeNode> Q=new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pFather = new Stack<>();
        Stack<TreeNode> qFather = new Stack<>();
        getPFather(root, p, pFather);
        getQFather(root, q, qFather);
        for(int i=Q.size()-1;i>=0;i--){
            for(int j=P.size()-1;j>=0;j--){
                if(Q.get(i).val==P.get(j).val){
                    System.out.println(Q.get(i).val);
                    return  Q.get(i);
                }
            }
        }
        return root;
    }
    private void  getQFather(TreeNode root, TreeNode q, Stack<TreeNode> qFather) {
        if(root==null){
            return;
        }
        if (root == q) {
            for (TreeNode node : qFather) {
                Q.add(node);
            }
            Q.add(root);
            return ;
        }
        qFather.push(root);
        getQFather(root.left, q, qFather);
        getQFather(root.right,q,qFather);
        qFather.pop();
    }

    private void getPFather(TreeNode root, TreeNode p, Stack<TreeNode> pFather) {
        if(root==null){
            return;
        }
        if(root==p){
            for (TreeNode node : pFather) {
                P.add(node);
            }
            P.add(root);

            return;
        }
        pFather.push(root);
        getPFather(root.left,p,pFather);
        getPFather(root.right,p,pFather);
        pFather.pop();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}