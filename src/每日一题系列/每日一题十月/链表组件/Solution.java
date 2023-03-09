package 每日一题系列.每日一题十月.链表组件;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 3, 1, 4};
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(solution.numComponents(l1, arr));
    }

    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int sum = 0;
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            boolean f = false;
            while (p != null && map.containsKey(pre.val) && map.containsKey(p.val)) {
                map.remove(pre.val);
                pre = p;
                p = p.next;
                f = true;
            }
            if (f && map.containsKey(pre.val)) {
                map.remove(pre.val);
                sum++;
            }
            pre = p;
            if (pre != null) {
                p = p.next;
            }
        }
        return sum + map.size();

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