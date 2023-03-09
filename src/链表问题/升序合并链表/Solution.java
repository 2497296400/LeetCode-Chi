package 链表问题.升序合并链表;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        int left=0;
        int right=lists.length-1;
        while (right>0){
            while (left<right){
                lists[left]=merge(lists[left],lists[right]);
                left++;
                right--;
            }
            left=0;
        }
        return  lists[0];
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode head=new ListNode(0);
        ListNode pre=head;
        while (n1!=null&&n2!=null){
            if(n1.val<n2.val){
                pre.next=n1;
                n1=n1.next;
                pre=pre.next;
            }
            else {
                pre.next=n2;
                n2=n2.next;
                pre=pre.next;

            }

        }
        pre.next= n1==null?n2:n1;
        return head;
    }
}
