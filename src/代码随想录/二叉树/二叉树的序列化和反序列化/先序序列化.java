package 代码随想录.二叉树.二叉树的序列化和反序列化;


import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.树的节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 先序序列化 {
    public static void main(String[] args) {
        TreeNode treeNode = LeetCodeUtils.GetTreeNode(new Integer[]{1, 2, 3, null, null, 4});
        String pre = fun(treeNode);
        System.out.println(pre);
        String postorder = postorder(treeNode);
        System.out.println(postorder);
        String[] split = pre.split(" ");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.add(s);
        }
        TreeNode preT = getFun(queue);
        LeetCodeUtils.treePrint(preT);
        Stack<String> queue2 = new Stack<>();
        for (String s : postorder.split(" ")) {
            queue2.add(s);
        }
        TreeNode postT = getPsot(queue2);
        LeetCodeUtils.treePrint(postT);
    }

    private static TreeNode getPsot(Stack<String> queue2) {
        if (queue2.isEmpty()) {
            return null;
        }
        String poll = queue2.pop();
        if (poll.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(poll));
        treeNode.right = getPsot(queue2);
        treeNode.left = getPsot(queue2);
        return treeNode;
    }

    private static TreeNode getFun(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String poll = queue.poll();
        if (poll.equals("#")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(poll));
        newNode.left = getFun(queue);
        newNode.right = getFun(queue);
        return newNode;
    }

    private static String fun(TreeNode treeNode) {
        if (treeNode == null) {
            return "# ";
        }
        return treeNode.val + " " + fun(treeNode.left) + fun(treeNode.right);
    }

    private static String postorder(TreeNode treeNode) {
        if (treeNode == null) {
            return "# ";
        }
        return postorder(treeNode.left) + postorder(treeNode.right)  + treeNode.val+" ";
    }
}
