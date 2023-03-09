package 链表问题.合并零之间的节点;



public class Dome {
    public static void main(String[] args) {
        Solution s=new Solution();
       ListNode l1=new ListNode(0);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(1);
        l1.next.next.next=new ListNode(0);
        l1.next.next.next.next=new ListNode(4);
        l1.next.next.next.next.next=new ListNode(5);
        l1.next.next.next.next.next.next=new ListNode(2);
        l1.next.next.next.next.next.next.next=new ListNode(0);
        System.out.println(s.mergeNodes(l1));
    }
}
