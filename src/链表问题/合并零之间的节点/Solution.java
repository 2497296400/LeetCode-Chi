package 链表问题.合并零之间的节点;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=new ListNode();
        ListNode temp1=temp;
        ListNode p1=head,p2=head;
        while(p2!=null){
            int sum=0;
            while(p1!=null){
                sum+=p1.val;
                p1=p1.next;
                if(p1.val==0){
                    p2=p1;
                    break;
                }
            }
            ListNode ptemp=new ListNode(sum);
            temp1.next=ptemp;
            temp1=ptemp;
            p2=p2.next;
        }
        return temp.next;
    }
}
