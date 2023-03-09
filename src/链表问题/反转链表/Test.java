package 链表问题.反转链表;

import java.nio.file.Path;
import java.util.List;

public class Test {
   public ListNode res(ListNode head){
       ListNode cur=head;
       ListNode next;
       ListNode pre=null;
       while (cur!=null){
           next=cur.next;
           cur.next=pre;
           pre=cur;
           cur=next;
       }
       return pre;
   }
   public  ListNode f(ListNode head){
       if(head.next==null){
           return head;
       }
       ListNode node=f(head.next);
       head.next.next=head;
       head.next=null;
       return node;
   }
}
