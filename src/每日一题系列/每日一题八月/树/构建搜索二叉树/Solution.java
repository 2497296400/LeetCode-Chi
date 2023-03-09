package 每日一题系列.每日一题八月.树.构建搜索二叉树;

import 动态规划问题.解码方法.T;

public class Solution {
    public TreeNode buildTreeFromFi(int[] arr) {
        return fun(arr, 0, arr.length - 1);
    }

    private TreeNode fun(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int curIndex = left + 1;
        for (; curIndex <= right; curIndex++) {
            if (arr[curIndex] > arr[left]) {
                break;
            }
        }
        TreeNode curNode = new TreeNode(arr[left]);
        curNode.left = fun(arr, left + 1, curIndex - 1);
        curNode.right = fun(arr, curIndex, right);
        return curNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
