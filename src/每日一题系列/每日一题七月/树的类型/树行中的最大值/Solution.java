package 每日一题系列.每日一题七月.树的类型.树行中的最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        findMaxAns(ans,root);
        return  ans;
    }

    private void findMaxAns(List<Integer> ans, TreeNode root) {
        Queue<TreeNode>treeNodeQueue=new LinkedList<>();
        if(root==null){
            return;
        }
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            int max=Integer.MIN_VALUE;
            int len=treeNodeQueue.size();
            for(int i=0;i<len;i++){
                TreeNode treeNode = treeNodeQueue.poll();
                max=Math.max(treeNode.val,max);
                if(treeNode.left!=null){
                    treeNodeQueue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    treeNodeQueue.add(treeNode.right);
                }
            }
            ans.add(max);
        }
    }
    public class TreeNode {
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
}
