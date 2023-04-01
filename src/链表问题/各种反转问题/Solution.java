package 链表问题.各种反转问题;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.链表节点.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode node = LeetCodeUtils.getNode(arr);

        ListNode resver = solution.swapPairs(node);
        // ListNode aFor = solution.resverFor(resver);
        solution.print(resver);

        // solution.print(aFor);
    }

    public void print(ListNode head) {
        System.out.println("====================>");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode resver(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = resver(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    public ListNode resverFor(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode preNode;

    public ListNode resver(ListNode head, int N) {
        if (N == 1) {
            preNode = head.next;
            return head;
        }
        ListNode lastNode = resver(head.next, N - 1);
        head.next.next = head;
        head.next = preNode;
        return lastNode;
    }

    public ListNode resver(ListNode head, int f, int s) {
        if (f == 1) {
            return resver(head, s);
        }
        head.next = resver(head.next, f - 1, s - 1);
        return head;
    }

    public ListNode resverGroup(ListNode head, int N) {
        if (head == null) {
            return null;
        }
        ListNode start, end;
        start = end = head;
        for (int i = 0; i < N; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        ListNode newHead = resver(start, end);
        start.next = resverGroup(end, N);
        return newHead;
    }

    private ListNode resver(ListNode start, ListNode end) {
        ListNode cur = start, pre = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode swapPairs = swapPairs(next.next);
        next.next = head;
        head.next = swapPairs;
        
        return swapPairs;
    }
}
