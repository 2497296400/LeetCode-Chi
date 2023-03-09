package 树的一些列问题.二叉树的序列化与反序列化;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.right = t5;
        t3.left = t4;
        codec.deserialize(codec.serialize(t1));
    }

}

class Codec {
    StringBuilder data =new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return "";
        }
        queue.add(root);
        int curDeep = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
               if(poll==null){
                   data.append("* ");
               }else {
                   data.append(poll.val).append(" ");
                   queue.add(poll.left);
                   queue.add(poll.right);
               }
            }
        }
        return String.valueOf(data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] split = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(split[0]));
        LinkedList<TreeNode>qu=new LinkedList<>();
        qu.add(node);
        int cur=1;
        while (cur<split.length){
            TreeNode last = qu.removeLast();
            if(!"*".equals(split[cur])){
                last.left=new TreeNode(Integer.parseInt(split[cur]));
                qu.addFirst(last.left);
            }
            cur++;
            if(!"*".equals(split[cur])){
                last.right=new TreeNode(Integer.parseInt(split[cur]));
                qu.addFirst(last.right);
            }
            cur++;
        }
        TreeNode curNode=new TreeNode(Integer.parseInt(split[0]));
       //  fun(split, curNode, split.length, 1);
         return node;
    }
    private void fun(String[] nums, TreeNode node, int len, int cur) {
        if (cur <= len) {
            node.val = Integer.parseInt(nums[cur - 1]);
            if (2 * cur <= len && !nums[2 * cur - 1] .equals("*")) {
                node.left = new TreeNode(Integer.parseInt(nums[2 * cur - 1]));
                fun(nums, node.left, len, 2 * cur);
            }
            if (2 * cur + 1 <= len && !nums[2 * cur].equals("*")) {
                node.right = new TreeNode(Integer.parseInt(nums[2 * cur]));
                fun(nums, node.right, len, 2 * cur + 1);
            }
        }
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