package 链表问题.K个一组翻转链表;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        solution.reverseKGroup(l1,4);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int sum = 0;
        ListNode curNode = head;
        while (curNode != null) {
            sum++;
            curNode = curNode.next;
        }
        curNode = head;
        ListNode pre=null;
        ListNode temp=new ListNode(0);
        ListNode ans=temp;
        int curIndex = 0;
        for (int i = 0; i < sum-k; i += k) {
            ListNode next;
            for (int j = 0; j < k; j++) {
                next = curNode.next;
                curNode.next = pre;
                pre = curNode;
                curNode = next;
            }
            temp.next=pre;
            while(temp.next!=null){
                temp=temp.next;
            }
            pre=null;
        }
        if(curNode!=null){
            temp.next=curNode;
        }
        return ans.next;
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