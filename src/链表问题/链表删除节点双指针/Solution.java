package 链表问题.链表删除节点双指针;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode seconde=head;
        for(int i=0;i<n;i++){
            first=first.next;
    }
        for(;first!=null;first=first.next,seconde=seconde.next);
        seconde=seconde.next.next;
        return head;
    }

}
