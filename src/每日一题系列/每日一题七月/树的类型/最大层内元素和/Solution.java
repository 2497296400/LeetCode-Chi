package 每日一题系列.每日一题七月.树的类型.最大层内元素和;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxLevelSum(TreeNode root) {
      Queue<TreeNode>queue=new LinkedList<>();
      int curIndex=0;
      Data curData=new Data();
      queue.add(root);
      while (!queue.isEmpty()){
       int curLen=queue.size();
       int curMax=0;
       for(int i=0;i<curLen;i++){
        TreeNode node = queue.poll();
        curMax+=node.val;
        if(node.left!=null){
         queue.add(node.left);
        }
        if(node.right!=null){
         queue.add(node.right);

        }
       }
       curIndex++;
       if(curMax>curData.curMax){
        curData.curMax=curMax;
        curData.curIndex=curIndex;
       }
      }
      return  curData.curIndex;

    }
 class Data{
     int curMax;
     int curIndex;
  public Data() {
   this.curMax = Integer.MIN_VALUE;
   this.curIndex = 0;
  }
 }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}