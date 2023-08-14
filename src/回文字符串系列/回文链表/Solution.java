package 回文字符串系列.回文链表;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(new Solution().isP(head));
    }

    ListNode preNode;

    public boolean isP(ListNode head) {
        if (head.next == null) {
            return true;
        }
        preNode = head;
        return fun(head);
    }

    private boolean fun(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = fun(head.next);
        if (res && preNode.val == head.val) {
            preNode = preNode.next;
            return true;
        }
        return false;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode first = head;
        ListNode second = head.next.next;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        ListNode lastNode;
        if (second == null) {
            lastNode = first.next;
        } else {
            lastNode = first.next.next;
        }
        first.next = null;
        ListNode pre = null;
        ListNode curNode = head;
        ListNode next;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        while (pre != null && lastNode != null) {
            if (pre.val != lastNode.val) {
                return false;
            }
            pre = pre.next;
            lastNode = lastNode.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}