package 链表问题.删除重复的节点;

import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(0, head);
        ListNode cur = dumy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next.val == temp) {
                cur.next=cur.next.next;
                }
            }
            else {
                cur= cur.next;
            }
        }
        return dumy.next;
    }
}
