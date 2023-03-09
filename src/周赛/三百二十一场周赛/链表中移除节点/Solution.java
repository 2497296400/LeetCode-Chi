package 周赛.三百二十一场周赛.链表中移除节点;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(13);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(8);
        ListNode l6 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode node = solution.removeNodes(l1);

    }

    public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (cur!= null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        int n = arrayList.size();
        int[] lastMax = new int[n];
        lastMax[n - 1] = arrayList.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            lastMax[i] = Math.max(lastMax[i + 1], arrayList.get(i));
        }
        ListNode ans = new ListNode(0);
        ListNode curAns = ans;
        for (int i = 0; i < n; i++) {
            if (arrayList.get(i) == lastMax[i]) {
                ans.next = new ListNode(lastMax[i]);
                ans = ans.next;
            }
        }
        return curAns.next;
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