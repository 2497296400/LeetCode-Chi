package Top集合.倒数第K个链表反转;

import 力扣工具类.力扣树的序列化.LeetCodeUtils;
import 力扣工具类.链表节点.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = LeetCodeUtils.getNode(new int[]{1, 2, 3, 4, 5});
        ListNode resver = resver(listNode, 5);
        LeetCodeUtils.printListNode(resver);
    }

    private static ListNode resver(ListNode listNode, int k) {
        if (listNode == null) {
            return null;
        }
        ListNode f = listNode, s = listNode;
        for (int i = 0; i < k; i++) {
            if (s == null) {
                return listNode;
            }
            s = s.next;
        }
        ListNode newNode = resver(f, s);
        f.next = resver(s, k);
        return newNode;
    }

    private static ListNode resver(ListNode f, ListNode s) {
        ListNode pre = f;
        while (f != s) {
            ListNode next = f.next;
            f.next = pre;
            pre = f;
            f = next;
        }
        return pre;
    }
}
