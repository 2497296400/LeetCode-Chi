package 网易五道题.链表随机节点;

import java.util.ArrayList;
import java.util.Random;

public class Solution {
    ListNode head;
    Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode p = head;
        int count = 0;
        int res = 0;
        while (p != null) {
            count++;
            if (count == random.nextInt(count) + 1) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}