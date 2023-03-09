package 精选一百道题.回文链表;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }
        ListNode first=head;
        ListNode second=head.next.next;
        int len=0;
        while (second!=null&&second.next!=null){
            first=first.next;
            second=second.next.next;
            len++;
        }
        ListNode lastNode;
        if(second==null){
            lastNode=first.next;
        }else {
            lastNode=first.next.next;
        }
        first.next=null;
        ListNode pre=null;
        ListNode curNode=head;
        ListNode next;
        while (curNode!=null){
            next=curNode.next;
            curNode.next=pre;
            pre=curNode;
            curNode=next;
        }
        while (pre!=null&&lastNode!=null){
            if(pre.val!=lastNode.val){
                return false;
            }
            pre=pre.next;
            lastNode=lastNode.next;
        }
        return true;
    }
}
  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }