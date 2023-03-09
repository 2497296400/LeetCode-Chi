package 链表问题.环形链表;


public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        public boolean hasCycle(ListNode head) {
            if (head==null||head.next == null||head.next.next==null) {
                return false;
            }
            ListNode p1 = head.next;
            ListNode p2 = head.next.next;
            while (p2!=p1){
                if(p2.next==null||p2.next.next==null){
                    return false;
                }
                p1=p1.next;
                p2=p2.next.next;

            }
            return true;
        }
    }
}