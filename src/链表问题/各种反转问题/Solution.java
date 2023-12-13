package 链表问题.各种反转问题;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.链表节点.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode node = LeetCodeUtils.getNode(arr);
        node = solution.resver(node);
        solution.print(node);

        ListNode resver = solution.reverGrapNode(node, 5);
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
        if (head.next == null) {
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
        return next;
    }

    //
    private ListNode reversalNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode lastNode = reversalNode(head.next);
        lastNode.next = head;
        head.next = null;
        return lastNode;
    }

    ListNode preNodeTest = null;

    private ListNode reversalNode(ListNode head, int n) {
        if (n == 1) {
            preNodeTest = head.next;
            return head;
        }
        ListNode lastNode = reversalNode(head.next, n - 1);
        head.next.next = head;
        head.next = preNodeTest;
        return lastNode;
    }

    private ListNode reversalNode(ListNode head, int m, int n) {
        if (m == 1) {
            return reversalNode(head, n);
        }
        head.next = reversalNode(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode swapNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode lastNode = swapNode(head.next);
        next.next = head;
        head.next = lastNode;
        return lastNode;
    }

    public ListNode reverGrapNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start = head, end = head;
        for (int i = 0; i < k; i++) {
            if (end.next == null) {
                return head;
            }
            end = end.next;
        }
        ListNode newNode = resver(start, end);
        start.next = reverGrapNode(end, k);
        return newNode;
    }

    public ListNode resvers(ListNode f, ListNode s) {
        ListNode pre = null;
        while (f != s) {
            ListNode next = f.next;
            f.next = pre;
            pre = f;
            f = next;
        }
        return pre;
    }
}
