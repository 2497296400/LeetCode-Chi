package 链表问题.删除重复的节点;


import java.util.Arrays;

public class Dome {
    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);

        l1.next.next.next .next= new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);
        System.out.println(s.deleteDuplicates(l1));
    }
}
