package 力扣工具类.力扣树的序列化;

import 力扣工具类.树的节点.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeUtils {
    public static TreeNode GetTreeNode(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<Integer> deque = new LinkedList<>();
        for (Integer integer : arr) {
            deque.add(integer);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        deque.poll();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            curNode.left = curGetNode(deque);
            curNode.right = curGetNode(deque);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return root;
    }

    private static TreeNode curGetNode(Queue<Integer> deque) {
        if (deque.peek() == null) {
            deque.poll();
            return null;
        } else {
            return new TreeNode(deque.poll());
        }
    }
}