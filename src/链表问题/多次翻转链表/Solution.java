package 链表问题.多次翻转链表;

import java.nio.file.Path;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        fun1(solution.getAns(node1));
    }

    private static void fun1(ListNode ans) {
        while (ans != null) {
            System.out.println(ans.var);
            ans = ans.next;

        }
    }

    public ListNode getAns(ListNode head) {
       // head = reverseListTow(head);
        return reverseFun(head);

    }

    private ListNode reverseListTow(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode cur = reverseListTow(head.next.next);
        next.next = head;
        head.next = cur;
        return next;
    }
    private ListNode reverseFun(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
       ListNode cur =  reverseFun( head.next);
        head.next.next=head;
        head.next=null;
        return cur;
    }
    private ListNode fun(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = fun(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

class ListNode {
    int var;
    ListNode next;

    public ListNode(int var) {
        this.var = var;
    }

    public ListNode(int var, ListNode next) {
        this.var = var;
        this.next = next;
    }
}
