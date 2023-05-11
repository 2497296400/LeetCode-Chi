package 力扣工具类.力扣树的序列化;

import 力扣工具类.树的节点.TreeNode;
import 力扣工具类.树的输出.TreePrint;
import 力扣工具类.链表节点.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public static void treePrint(TreeNode root) {
        TreePrint.print(root);
    }

    public static int[][] getIntTow(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        char[] chars = s.toCharArray();
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                String c = "";
                while (chars[++i] != ']') {
                    c += chars[i];
                }
                List<Integer> cl = new ArrayList<>();
                String[] split = c.split(",");
                for (String s1 : split) {
                    cl.add(Integer.valueOf(s1));
                }
                lists.add(cl);
            }
        }
        int[][] g = new int[lists.size()][lists.get(0).size()];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                g[i][j] = lists.get(i).get(j);
            }
        }
        return g;
    }

    public static int[] getIntOne(String s) {
        int[][] intTow = getIntTow("[" + s + ']');
        return intTow[0];
    }
}