package 链表问题.回文链表;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l1.next.next = l3;
        // l1.next.next.next=l4;
//      //  l1.next.next.next.next=l5;
        System.out.println(solution.isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        if (head.next == null) {
            return true;
        }
        ListNode second = head.next.next;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        ListNode lastNode;
        if (second != null) {
            lastNode = first.next.next;
        } else {
            lastNode = first.next;
        }

        first.next = null;
        ListNode curNode = head;
        ListNode pre = null;
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