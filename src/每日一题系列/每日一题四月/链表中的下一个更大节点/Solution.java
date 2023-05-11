package 每日一题系列.每日一题四月.链表中的下一个更大节点;

import 力扣工具类.链表节点.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }

        Stack<Integer> stack = new Stack<>();
        int len = arrayList.size();
        int[] arr = new int[len];
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = arrayList.get(i);
        }
        len = len - 1;
        while (len > 0) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[len]) {
                stack.pop();
            }
            ans[len] = stack.isEmpty() ? 0 : arr[stack.peek()];
            stack.add(len);
        }
        return ans;
    }
}
