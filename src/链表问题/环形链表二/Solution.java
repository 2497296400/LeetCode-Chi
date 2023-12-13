package 链表问题.环形链表二;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public static void main(String[] args) {
            ListNode p1=new ListNode(1);
            ListNode p2=new ListNode(2);
            ListNode p3=new ListNode(3);
            ListNode p4=new ListNode(4);
            p1.next=p2;
            p1.next.next=p3;
            p1.next.next.next=p4;
            p4.next=p2;
            ListNode head=p1;
            System.out.println(detectCycle(head));
            

        }
        public static ListNode detectCycle(ListNode head) {
            if (head == null||head.next==null||head.next.next==null)
                return null;
            ListNode p1 = head;
            ListNode p2 = head;
            while (p2 != p1) {
                if (p2.next == null || p2.next.next == null) {
                    return null;
                }
                p1 = p1.next;
                p2 = p2.next.next;
            }
            p2 = head;
            while (p2 != p1) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
    }
}
