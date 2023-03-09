package 链表问题.链表删除节点递归;

import java.util.Scanner;

public class Dome {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode();
        ListNode p2 = head;
        for (int i = 0; i < 5; i++) {
            Scanner temp = new Scanner(System.in);
            ListNode p1=new ListNode(temp.nextInt());
            p2.next=p1;
            p2=p1;
        }
        head=s.removeNthFromEnd(head.next,2);
        for(;head!=null;head=head.next){
            System.out.println(head.val);
        }
    }
}
