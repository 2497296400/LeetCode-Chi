package 链表问题.回文链表;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l1.next.next = l3;
        l1.next.next.next = l4;
        l1.next.next.next.next = l5;
        l1.next.next.next.next.next = l6;
//        System.out.println(solution.isPalindrome(l1));
//        System.out.println(isPalindrome2(l1));
        ListNode listNode = removeLast(l1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static ListNode left;

    public static boolean isPalindrome2(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = isPalindrome2(right.next);
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }

    static int cnt = 0;

    public static ListNode removeLast(ListNode head, int target) {
        if (head == null) return null;
        head.next = removeLast(head.next, target);
        cnt++;
        if (cnt == target) {
            return head.next;
        }
        return head;
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