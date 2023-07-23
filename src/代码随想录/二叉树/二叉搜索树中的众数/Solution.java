package 代码随想录.二叉树.二叉搜索树中的众数;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{2, 1, null, null, 2, 1, null, null, 2});
        System.out.println(Arrays.toString(solution.findMode(treeNode)));
    }

    int maxSum = 0;
    ArrayList<Integer> arrayList = new ArrayList();
    int ta = 0;

    public int[] findMode(TreeNode root) {

        fun(root);
        pre = null;
        ta = 1;
        fun(root);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }


    TreeNode pre;
    int curSum = 0;

    private void fun(TreeNode root) {
        if (root == null) return;
        fun(root.left);
        if (pre != null && root.val == pre.val) {
            maxSum = Math.max(maxSum, ++curSum);
        } else {
            curSum = 0;
        }
        pre = root;
        // System.out.println(root.val);
        if (maxSum == curSum && ta == 1) {
            arrayList.add(root.val);
        }
        fun(root.right);
    }
}
