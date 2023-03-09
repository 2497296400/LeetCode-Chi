package 树的一些列问题.恢复二叉搜索树;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        toGetAll(root, list);
        int[] swap = toGetSwapIndex(list);
        toSwap(root,2,swap[0],swap[1]);

    }

    private void toSwap(TreeNode root, int curTime, int first, int second) {
        if(root!=null){
            if(root.val==first||root.val==second){
                root.val=root.val==first?second:first;
                curTime--;
                if(curTime==0){
                    return;
                }
            }
            toSwap(root.left,curTime,first,second);
            toSwap(root.right,curTime,first,second);
        }
    }

    private int[] toGetSwapIndex(List<Integer> list) {
        int n=list.size()-1;
        int index1=-1,index2=-1;
        for(int i=0;i<n;i++){
            if(list.get(i+1)<list.get(i)){
                index2=i+1;
                if(index1==-1){
                    index1=i;

                }else {
                    break;
                }
            }
        }
        return new int []{list.get(index1),list.get(index2)};
    }

    private void toGetAll(TreeNode root, List<Integer> list) {
        if (root != null) {
            toGetAll(root.left, list);
            list.add(root.val);
            toGetAll(root.right, list);
        }
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