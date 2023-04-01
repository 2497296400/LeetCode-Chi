package 力扣工具类.力扣树的序列化;

import 力扣工具类.树的节点.TreeNode;
import 力扣工具类.树的输出.TreePrint;
import 力扣工具类.链表节点.ListNode;

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
    
    public static ListNode getNode(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode head = node;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head;
    }
    public  static void treePrint(TreeNode root){
        TreePrint.print(root);
    }
}