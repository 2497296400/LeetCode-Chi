package 链表问题.链表删除节点递归;

public class Solution {
    public int cur = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        head.next= removeNthFromEnd(head.next, n);
        cur++;
        if (n == cur) return head.next;
        return head;
    }

}
