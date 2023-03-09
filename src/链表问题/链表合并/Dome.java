package 链表问题.链表合并;

public class Dome {
    public static void main(String[] args) {
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();
        l1.val=1;
        l1.next=new ListNode(4);
        l2.val=2;
        l2.next=new ListNode(3);
        Solution s=new Solution();
        System.out.println(s.mergeTwoLists(l1,l2));
    }
}
