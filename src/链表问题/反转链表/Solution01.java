package 链表问题.反转链表;

public class Solution01 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return  newHead;
    }
}
