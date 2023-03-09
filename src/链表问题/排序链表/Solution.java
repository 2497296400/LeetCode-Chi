package 链表问题.排序链表;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(2);
        head = sortList(head);
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = midNode(head);
        ListNode rightNode = midNode.next;
        midNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        return merge(left, right);
    }

    private static ListNode midNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode head, ListNode last) {
        ListNode p2 = new ListNode(0);
        ListNode p1 = p2;
        while (head != null && last != null) {
            if (head.val < last.val) {
                p1.next = head;
                p1 = p1.next;
                head = head.next;
            } else {
                p1.next = last;
                p1 = p1.next;
                last = last.next;
            }
        }
        p1.next = head == null ? last : head;
        return p2.next;
    }
}

