package 每日一题系列.每日一题九月.寻找重复的子树;

import java.util.*;

public class Solution {
    List<TreeNode> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(2);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.left=t5;
        Solution solution = new Solution();
        System.out.println(solution.findDuplicateSubtrees(t1));
    }
    HashMap<String,Integer>map=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        fun(root);
        return ans;
    }

    private String fun(TreeNode root) {
     String  str;
     if(root==null) {
         return  "*";
     }
     str = root.val + " "+ fun( root.left) + " " + fun( root. right);
     if(map.containsKey(str)&& map.get(str)==1){
         ans.add(root);
     }
     map.put(str, map.getOrDefault(str, 0)+1);
     return  str;
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