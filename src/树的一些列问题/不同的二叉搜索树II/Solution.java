package 树的一些列问题.不同的二叉搜索树II;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3));
    }
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);

    }

    private  List<TreeNode> dfs(int left, int right) {
        List<TreeNode>ans=new LinkedList<>();
        if(left>right){
            ans.add(null);
            return ans;
        }
        for(int i=left;i<=right;i++){
            List<TreeNode> leftNode = dfs(left, i - 1);
            List<TreeNode> rightNode = dfs(i + 1, right);
            for (TreeNode nodeLeft : leftNode) {
                for (TreeNode nodeRight : rightNode) {
                    ans.add(new TreeNode(i,nodeLeft,nodeRight));
                }
            }
        }
        return ans;
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